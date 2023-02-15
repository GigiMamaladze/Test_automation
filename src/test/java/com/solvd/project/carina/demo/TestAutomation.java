package com.solvd.project.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.project.carina.demo.gui.components.accordion.ResizeAccordionPage;
import com.solvd.project.carina.demo.gui.components.accordion.SimpleAccordionPage;
import com.solvd.project.carina.demo.gui.components.autocomplete.CategoriesPage;
import com.solvd.project.carina.demo.gui.components.autocomplete.ComboBoxPage;
import com.solvd.project.carina.demo.gui.components.datapicker.DropDownDataPage;
import com.solvd.project.carina.demo.gui.components.datapicker.SimpleDataPickerPage;
import com.solvd.project.carina.demo.gui.components.dragdrop.AcceptedElementPage;
import com.solvd.project.carina.demo.gui.components.dragdrop.PhotoManagerPage;
import com.solvd.project.carina.demo.gui.components.draggablebox.CheckEventsPage;
import com.solvd.project.carina.demo.gui.components.draggablebox.SimpleDragPage;
import com.solvd.project.carina.demo.gui.components.progresbar.DownloadManagerPage;
import com.solvd.project.carina.demo.gui.components.progresbar.RandomProgressPage;
import com.solvd.project.carina.demo.gui.components.select.MultipleSelectionPage;
import com.solvd.project.carina.demo.gui.components.slider.SliderColorPage;
import com.solvd.project.carina.demo.gui.components.slider.SliderRangePage;
import com.solvd.project.carina.demo.gui.components.sorting.MultipleListsPage;
import com.solvd.project.carina.demo.gui.components.sorting.PortletsPage;
import com.solvd.project.carina.demo.gui.components.spinner.CurrencyPage;
import com.solvd.project.carina.demo.gui.components.spinner.SimpleSpinnerPage;
import com.solvd.project.carina.demo.gui.components.toolbar.SplitButtonPage;
import com.solvd.project.carina.demo.gui.components.toolbar.ToolBarOptionsPage;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipImagePage;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipVideoPage;
import com.solvd.project.carina.demo.gui.pages.*;
import com.solvd.project.carina.demo.gui_componenets.enums.*;
import com.solvd.project.carina.demo.gui_componenets.exceptions.IncorectDayException;
import com.solvd.project.carina.demo.gui_componenets.exceptions.IncorectMenuException;
import com.solvd.project.carina.demo.gui_componenets.exceptions.IncorectYearException;
import com.solvd.project.carina.demo.gui_componenets.utils.DataFormatUtil;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import jdk.jfr.Description;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAutomation implements IAbstractTest {

    @Test(groups = "First_step")
    @MethodOwner(owner = "Gigi")
    @Description("Only working clearly slider which have one handle")
    public void testSliders() throws IncorectMenuException {
        SliderPage sliderPage = new SliderPage(getDriver());
        sliderPage.openURL("https://www.globalsqa.com/demo-site/sliders/");
        Assert.assertTrue(sliderPage.isPageOpened(2), "Slider Page is not opened");
        SliderColorPage sliderColorPage = new SliderColorPage(getDriver());
        String color = "red";
        Assert.assertTrue(sliderColorPage.isFrameOpened(), "Color picker frame is not opened");
        sliderColorPage.moveSlider(color, 100);
        SliderRangePage sliderRangePage = (SliderRangePage) sliderPage.getMenu()
                .clickOnMenuOption(MenuOption.RANGE);
        Assert.assertTrue(sliderRangePage.isFrameOpened(), "Range frame is not opened");
        String beforeMoveHandle = sliderRangePage.getHandlesRange();
        sliderRangePage.moveRightSlider(1000);
        sliderRangePage.moveLeftSlider(2000);
        String afterMoveHande = sliderRangePage.getHandlesRange();
        Assert.assertNotEquals(beforeMoveHandle, afterMoveHande, "Slider handles is not moved");
    }

    @Test(groups = "First_step")
    @MethodOwner(owner = "Gigi")
    public void testTooltip() throws IncorectMenuException {
        TooltipPage tooltipPage = new TooltipPage(getDriver());
        tooltipPage.openURL("https://www.globalsqa.com/demo-site/tooltip/");
        getDriver().manage().window().fullscreen();
        Assert.assertTrue(tooltipPage.isPageOpened(2), "ToolTip Page is not opened");
        TooltipImagePage tooltipImagePage = new TooltipImagePage(getDriver());
        Assert.assertTrue(tooltipImagePage.isFrameOpened(), "Image frame is not opened");
        String image = "Tower Bridge";
        tooltipImagePage.scrollToImage(image);
        tooltipImagePage.hoverImage(image);
        Assert.assertEquals(tooltipImagePage.getActualToolTip(), image, "Tooltip is not displayed");
        TooltipVideoPage tooltipVideoPage = (TooltipVideoPage) tooltipPage.getMenu()
                .clickOnMenuOption(MenuOption.VIDEO_BASED);
        Assert.assertTrue(tooltipVideoPage.isFrameOpened(), "Video based frame is not opened");
        tooltipVideoPage.scrollToButtons();
        tooltipVideoPage.hoverLikeButton();
        Assert.assertTrue(tooltipVideoPage.isTooltipDisplayed(), "Tool tip is not displayed");
    }

    @Test(groups = "First_step")
    @MethodOwner(owner = "Gigi")
    public void testProgressBar() throws IncorectMenuException {
        ProgressBarPage progressBarPage = new ProgressBarPage(getDriver());
        progressBarPage.openURL("https://www.globalsqa.com/demo-site/progress-bar/");
        Assert.assertTrue(progressBarPage.isPageOpened(2), "Progress bar page is opened");
        DownloadManagerPage downloadManagerPage = new DownloadManagerPage(getDriver());
        Assert.assertTrue(downloadManagerPage.isFrameOpened(), "Download manager frame is not opened");
        downloadManagerPage.clickDownloadBtn();
        Assert.assertEquals(downloadManagerPage.getProgressBarLabel(), "Starting download...", "Downloading is not started");
        downloadManagerPage.waitForProgressDownload();
        Assert.assertEquals(downloadManagerPage.getProgressBarLabel(), "Complete!", "Downloading is not completed");
        RandomProgressPage randomProgressPage = (RandomProgressPage) progressBarPage.getMenu()
                .clickOnMenuOption(MenuOption.RANDOM_PROGRESS_BAR);
        Assert.assertTrue(randomProgressPage.isFrameOpened(), "Random Progress frame is not opened");
        String indeterminatePercentage = randomProgressPage.getActualPercentage();
        randomProgressPage.clickRandomValueBtn();
        Assert.assertNotEquals(indeterminatePercentage, randomProgressPage.getActualPercentage(), "Percentage is not changed");
        randomProgressPage.clickIndeterminateBtn();
        Assert.assertNull(randomProgressPage.getActualPercentage(), "Progress bar is not in indeterminate process");
    }

    @Test(groups = "Second_step")
    @MethodOwner(owner = "Gigi")
    public void testFramesAndWindows() {
        FramesAndWindowsPage framesAndWindowsPage = new FramesAndWindowsPage(getDriver());
        framesAndWindowsPage.openURL("https://www.globalsqa.com/demo-site/frames-and-windows/");
        Assert.assertTrue(framesAndWindowsPage.isPageOpened(2), "Frames and windows page is not opened");
        int initialWindowHandles = getDriver().getWindowHandles().size();
        framesAndWindowsPage.clickClickHereBtn();
        int updatedWindowHandles = getDriver().getWindowHandles().size();
        Assert.assertNotEquals(initialWindowHandles, updatedWindowHandles, "Windows or tabs is not opened");
    }

    @Test(groups = "Second_step")
    @MethodOwner(owner = "Gigi")
    public void testAccordion() throws IncorectMenuException {
        AccordionAndTabsPage accordionAndTabsPage = new AccordionAndTabsPage(getDriver());
        accordionAndTabsPage.openURL("https://www.globalsqa.com/demo-site/accordion-and-tabs/");
        Assert.assertTrue(accordionAndTabsPage.isPageOpened(2), "Accordion page is opened");
        SimpleAccordionPage simpleAccordionPage = new SimpleAccordionPage(getDriver());
        Assert.assertTrue(simpleAccordionPage.isFrameOpened(), "Simple frame is opened");
        String section = "Section 2";
        Assert.assertTrue(simpleAccordionPage.isSectionPresent(section), "Section is not present");
        simpleAccordionPage.scrollToSection(section);
        simpleAccordionPage.clickSection(section);
        Assert.assertTrue(simpleAccordionPage.isSectionOpened(section), "Section is not opened");
        ResizeAccordionPage resizeAccordionPage = (ResizeAccordionPage) accordionAndTabsPage.getMenu()
                .clickOnMenuOption(MenuOption.RESIZE_ACCORDION);
        Assert.assertTrue(resizeAccordionPage.isFrameOpened(), "Re-size frame is not opened");
        for (int i = 0; i < resizeAccordionPage.getSectionsCount(); i++) {
            resizeAccordionPage.clickSection(i);
            Assert.assertTrue(resizeAccordionPage.isSectionTextDisplayed(i), "Section text is not displayed");
        }
    }

    @Test(groups = "Second_step")
    @MethodOwner(owner = "Gigi")
    public void testAutoComplete() throws IncorectMenuException {
        AutoCompletePage autoCompletePage = new AutoCompletePage(getDriver());
        autoCompletePage.openURL("https://www.globalsqa.com/demo-site/auto-complete/");
        Assert.assertTrue(autoCompletePage.isPageOpened(2), "Autocomplete page is opened");
        CategoriesPage categoriesPage = new CategoriesPage(getDriver());
        Assert.assertTrue(categoriesPage.isFrameOpened(), "Categories Frame is not opened");
        categoriesPage.typeInSearchTextField("a");
        String searchedText = "anders andersson";
        categoriesPage.clickSearchedText(searchedText);
        Assert.assertEquals(categoriesPage.getPrintedText(), searchedText, "Searched text is not displayed");
        ComboBoxPage comboBoxPage = (ComboBoxPage) autoCompletePage.getMenu()
                .clickOnMenuOption(MenuOption.COMBO_BOX);
        Assert.assertTrue(comboBoxPage.isFrameOpened(), "Combo box frame is not opened");
        String programingLanguage = "Java";
        comboBoxPage.clickShowAllItemBtn();
        comboBoxPage.selectProgramingLanguage(programingLanguage);
        Assert.assertEquals(comboBoxPage.getSelectedLanguage(), programingLanguage, "Chosen programming language is not displayed");
    }

    @Test(groups = "Second_step")
    @MethodOwner(owner = "Gigi")
    public void testSelectElements() throws IncorectMenuException {
        SelectElementsPage selectElementsPage = new SelectElementsPage(getDriver());
        selectElementsPage.openURL("https://www.globalsqa.com/demo-site/select-elements/");
        Assert.assertTrue(selectElementsPage.isPageOpened(2), "Select Element frame is not opened");
        MultipleSelectionPage multipleSelectionPage = new MultipleSelectionPage(getDriver());
        Assert.assertTrue(multipleSelectionPage.isFrameOpened(), "Multiple Selection frame is not opened");
        String element = "Item 1";
        multipleSelectionPage.clickSectionElement(element);
        Assert.assertTrue(multipleSelectionPage.isSectionSelected(element), "Section element is not selected");
    }

    @Test(groups = "Third_step")
    @MethodOwner(owner = "Gigi")
    private void testSpinner() throws IncorectMenuException {
        SpinnerPage spinnerPage = new SpinnerPage(getDriver());
        spinnerPage.openURL("https://www.globalsqa.com/demo-site/spinner/");
        Assert.assertTrue(spinnerPage.isPageOpened(2), "Spinner Page is not opened");
        CurrencyPage currencyPage = new CurrencyPage(getDriver());
        Assert.assertTrue(currencyPage.isFrameOpened(), "Currency frame is not opened");
        currencyPage.selectCurrency(Currency.YEN);
        String initialAmount = currencyPage.getAmountDonate();
        currencyPage.clickUpSpinner();
        Assert.assertNotEquals(initialAmount, currencyPage.getAmountDonate(), "Amount is not changed");
        currencyPage.clickDownSpinner();
        Assert.assertEquals(initialAmount, currencyPage.getAmountDonate(), "Amount is not changed");
        SimpleSpinnerPage simpleSpinnerPage = (SimpleSpinnerPage) spinnerPage.getMenu()
                .clickOnMenuOption(MenuOption.SIMPLE_SPINNER);
        Assert.assertTrue(simpleSpinnerPage.isFrameOpened(), "Simple spinner frame is not opened");
        String initialValue = simpleSpinnerPage.getSelectedValue();
        simpleSpinnerPage.clickUpSpinner();
        Assert.assertNotEquals(initialValue, simpleSpinnerPage.getSelectedValue(), "Value is not changed");
        simpleSpinnerPage.clickUpSpinner();
        String upgradedValue = simpleSpinnerPage.getSelectedValue();
        simpleSpinnerPage.clickDownSpinner();
        Assert.assertNotEquals(upgradedValue, simpleSpinnerPage.getSelectedValue(), "Value is not changed");
        simpleSpinnerPage.clickToggleDisableBtn();
        Assert.assertTrue(simpleSpinnerPage.isSpinnerDisabled(), "Value field and spinner elements is not disabled");
        simpleSpinnerPage.clickToggleWidgetBtn();
        Assert.assertFalse(simpleSpinnerPage.isSpinnerPresent(), "Spinner is available");
        simpleSpinnerPage.clickToggleWidgetBtn();
        simpleSpinnerPage.clickSetValue5Btn();
        Assert.assertEquals(simpleSpinnerPage.getSelectedValue(), "5", "Value is not 5");
        String value = simpleSpinnerPage.getSelectedValue();
        Assert.assertEquals(simpleSpinnerPage.clickGetValueAndGetAlertText(), value, "Value is not present");
    }

    @Test(groups = "Third_step")
    @MethodOwner(owner = "Gigi")
    public void testDataPicker() throws IncorectYearException, IncorectMenuException, IncorectDayException {
        DataPickerPage dataPickerPage = new DataPickerPage(getDriver());
        dataPickerPage.openURL("https://www.globalsqa.com/demo-site/datepicker/");
        Assert.assertTrue(dataPickerPage.isPageOpened(2), "Data Picker page is not opened");
        SimpleDataPickerPage simpleDataPickerPage = new SimpleDataPickerPage(getDriver());
        Assert.assertTrue(simpleDataPickerPage.isFrameOpened(), "Simple data picker frame is not opened");
        simpleDataPickerPage.clickDataField();
        Assert.assertTrue(simpleDataPickerPage.isCalendarPresent(), "Calendar is not opened");
        Month month = Month.DECEMBER;
        int year = 2022;
        int day = 20;
        simpleDataPickerPage.choseMonthAndYear(month, year);
        Assert.assertEquals(simpleDataPickerPage.getMonthLabel(), month.toString(), "Month is not selected correctly");
        Assert.assertEquals(simpleDataPickerPage.getYearLabel(), String.valueOf(year), "Year is not selected correctly");
        Assert.assertTrue(simpleDataPickerPage.isDayPresent(day), "Day is not exist");
        simpleDataPickerPage.clickDay(day);
        Assert.assertEquals(simpleDataPickerPage.getActualDate(), DataFormatUtil.formatToDate(month, day, year), "Date is not correct");
        DropDownDataPage dropDownDataPage = (DropDownDataPage) dataPickerPage.getMenu()
                .clickOnMenuOption(MenuOption.DROP_DOWN_DATA_PICKER);
        Assert.assertTrue(dropDownDataPage.isFrameOpened(), "Drop down Data picker frame is not opened");
        dropDownDataPage.clickDataField();
        Assert.assertTrue(dropDownDataPage.isCalendarPresent(), "Calendar is not opened");
        dropDownDataPage.selectMonth(month);
        dropDownDataPage.selectYear(year);
        dropDownDataPage.clickDay(day);
        Assert.assertEquals(dropDownDataPage.getActualDate(), DataFormatUtil.formatToDate(month, day, year), "Date is not correct");
    }

    @Test(groups = "Third_step")
    @MethodOwner(owner = "Gigi")
    public void testSorting() throws IncorectMenuException {
        SortingPage sortingPage = new SortingPage(getDriver());
        sortingPage.openURL("https://www.globalsqa.com/demo-site/sorting/");
        getDriver().manage().window().fullscreen();
        Assert.assertTrue(sortingPage.isPageOpened(2), "Sorting page is not opened");
        PortletsPage portletsPage = new PortletsPage(getDriver());
        Assert.assertTrue(portletsPage.isFrameOpened(), "Portlets frame is not opened");
        String from = "Shopping";
        String to = "Feeds";
        Point target = portletsPage.getLocationPortlet(to);
        portletsPage.movePortlets(from, to);
        Assert.assertEquals(portletsPage.getLocationPortlet(from), target, "Portlet is not moved correctly");
        MultipleListsPage multipleListsPage = (MultipleListsPage) sortingPage.getMenu()
                .clickOnMenuOption(MenuOption.MULTIPLE_LIST);
        Assert.assertTrue(multipleListsPage.isFrameOpened(), "Multiple list Frame is not opened");
        for (int i = 1; i <= 5; i++) {
            Point initialWhiteItemLocation = multipleListsPage.getItemLocation(ItemType.WHITE, i);
            Point initialYellowItemLocation = multipleListsPage.getItemLocation(ItemType.YELLOW, i);
            multipleListsPage.moveItemToList(i, ItemType.WHITE, ItemList.RIGHT);
            Assert.assertNotEquals(initialWhiteItemLocation, multipleListsPage.getItemLocation(ItemType.WHITE, i), "Item is not moved");
            multipleListsPage.moveItemToList(i, ItemType.YELLOW, ItemList.LEFT);
            Assert.assertNotEquals(initialYellowItemLocation, multipleListsPage.getItemLocation(ItemType.YELLOW, i), "Item is not moved");
        }
    }

    @Test(groups = "Third_step")
    @MethodOwner(owner = "Gigi")
    public void testDragAndDrop() throws IncorectMenuException {
        DragAndDropPage dragAndDropPage = new DragAndDropPage(getDriver());
        dragAndDropPage.openURL("https://www.globalsqa.com/demo-site/draganddrop/");
        Assert.assertTrue(dragAndDropPage.isPageOpened(), "Drag and drop is not opened");
        PhotoManagerPage photoManagerPage = new PhotoManagerPage(getDriver());
        Assert.assertTrue(photoManagerPage.isFrameOpened(), "Photo Manager page is not opened");
        Image image = Image.HIGH_TATRAS_2;
        photoManagerPage.moveImageToTrash(image);
        Assert.assertTrue(photoManagerPage.isImageInTrash(image), "Image is not in trash");
        photoManagerPage.moveImageToGallery(image);
        Assert.assertTrue(photoManagerPage.isImageInGallery(image), "Image is not in gallery");
        photoManagerPage.clickDeleteImage(image);
        Assert.assertTrue(photoManagerPage.isImageInTrash(image), "Image is not in trash");
        photoManagerPage.clickRecycleImageBtn(image);
        Assert.assertTrue(photoManagerPage.isImageInGallery(image), "Image is not in gallery");
        photoManagerPage.clickViewImageLargerBtn(image);
        Assert.assertTrue(photoManagerPage.isImageDialogTitleDisplayed(image), "Image dialog title is not present");
        AcceptedElementPage acceptedElementPage = (AcceptedElementPage) dragAndDropPage.getMenu()
                .clickOnMenuOption(MenuOption.ACCEPTED_ELEMENTS);
        Assert.assertTrue(acceptedElementPage.isFrameOpened(), "Accepted Element Frame is not opened");
        acceptedElementPage.moveNonValidElementToTargetPanel();
        Assert.assertFalse(acceptedElementPage.isElementAccepted(), "Element is accepted");
        acceptedElementPage.moveDraggableBoxElementToTargetPanel();
        Assert.assertTrue(acceptedElementPage.isElementAccepted(), "Element is not accepted");
    }

    @Test(groups = "Third_step")
    @MethodOwner(owner = "Gigi")
    public void testDraggableBoxes() throws IncorectMenuException {
        DraggableBoxesPage draggableBoxesPage = new DraggableBoxesPage(getDriver());
        draggableBoxesPage.openURL("https://www.globalsqa.com/demo-site/draggableboxes/");
        Assert.assertTrue(draggableBoxesPage.isPageOpened(), "Draggable box page is not opened");
        SimpleDragPage simpleDragPage = new SimpleDragPage(getDriver());
        Assert.assertTrue(simpleDragPage.isFrameOpened(), "Simple Drag frame is not present");
        Point initialLocationOfBox = simpleDragPage.getLocationOfBox();
        simpleDragPage.moveBox(26, 13);
        Assert.assertNotEquals(initialLocationOfBox, simpleDragPage.getLocationOfBox(), "Box is not moved");
        CheckEventsPage checkEventsPage = (CheckEventsPage) draggableBoxesPage.getMenu()
                .clickOnMenuOption(MenuOption.CHECK_EVENTS);
        Assert.assertTrue(checkEventsPage.isFrameOpened(), "Check Event frame is not opened");
        String initialDragInvolveValue = checkEventsPage.getDragInvolveValue();
        String initialStopInvokeValue = checkEventsPage.getStopInvokeValue();
        String initialStartInvokeValue = checkEventsPage.getStartInvokeValue();
        checkEventsPage.moveBox(26, 13);
        Assert.assertNotEquals(initialStartInvokeValue, checkEventsPage.getStartInvokeValue(), "Start Event is not changed");
        Assert.assertNotEquals(initialDragInvolveValue, checkEventsPage.getDragInvolveValue(), "Drag Event is not changed");
        Assert.assertNotEquals(initialStopInvokeValue, checkEventsPage.getStopInvokeValue(), "Stop Event is not changed");
    }

    @Test(groups = "Third_step")
    @MethodOwner(owner = "Gigi")
    public void testToolBar() throws IncorectMenuException {
        ToolBarPage toolBarPage = new ToolBarPage(getDriver());
        toolBarPage.openURL("https://www.globalsqa.com/demo-site/toolbar/");
        Assert.assertTrue(toolBarPage.isPageOpened(), "ToolBar page is not opened");
        ToolBarOptionsPage toolBarOptionsPage = new ToolBarOptionsPage(getDriver());
        Assert.assertTrue(toolBarOptionsPage.isFrameOpened(), "Toolbar frame is not opened");
        toolBarOptionsPage.clickZoomBtn();
        ZoomPercentage zoomPercentage = ZoomPercentage.FIFTY;
        toolBarOptionsPage.clickZoomPercentage(zoomPercentage);
        Assert.assertTrue(toolBarOptionsPage.isZoomPercentageChanged(zoomPercentage), "Zoom percentage is not changed");
        Assert.assertTrue(toolBarOptionsPage.isFontNameButtonPresent(), "Font name button is not present");
        Assert.assertTrue(toolBarOptionsPage.isFontSizeButtonPresent(), "Font size button is not present");
        Assert.assertTrue(toolBarOptionsPage.isHighLightButtonPresent(), "High Light button is not present");
        Assert.assertTrue(toolBarOptionsPage.isColorButtonPresent(), "Color button is not present");
        SplitButtonPage splitButtonPage = (SplitButtonPage) toolBarPage.getMenu()
                .clickOnMenuOption(MenuOption.SPLIT_BUTTON);
        Assert.assertTrue(splitButtonPage.isFrameOpened(), "Split button frame is not opened");
        splitButtonPage.clickFunctionArrowBtn();
        Function function = Function.SAVE;
        splitButtonPage.clickFunction(function);
        Assert.assertTrue(splitButtonPage.isFunctionPresentInOutput(function), "Function is not present in output");
        splitButtonPage.clickRunLastOptionBtn();
        Assert.assertTrue(splitButtonPage.isRunLastOptionPresentInOutput(), "Run las option is not present in output");
    }
}
