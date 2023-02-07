package com.solvd.project.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.project.carina.demo.gui.components.accordion.ResizeAccordionPage;
import com.solvd.project.carina.demo.gui.components.accordion.SimpleAccordionPage;
import com.solvd.project.carina.demo.gui.components.autocomplete.CategoriesPage;
import com.solvd.project.carina.demo.gui.components.autocomplete.ComboBoxPage;
import com.solvd.project.carina.demo.gui.components.progresbar.DownloadManagerPage;
import com.solvd.project.carina.demo.gui.components.progresbar.RandomProgressPage;
import com.solvd.project.carina.demo.gui.components.select.MultipleSelectionPage;
import com.solvd.project.carina.demo.gui.components.slider.SliderColorPage;
import com.solvd.project.carina.demo.gui.components.slider.SliderRangePage;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipImagePage;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipVideoPage;
import com.solvd.project.carina.demo.gui.pages.*;
import com.solvd.project.carina.demo.gui_componenets.enums.MenuOptions;
import com.solvd.project.carina.demo.gui_componenets.exceptions.IncorectMenuException;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAutomation implements IAbstractTest {

    @Test(groups = "First_step")
    @MethodOwner(owner = "Gigi")
    @Description("Only working clearly slider which have one handle")
    public void testSliders() throws IncorectMenuException {
        SliderPage sliderPage = new SliderPage(getDriver());
        sliderPage.openURL("https://www.globalsqa.com/demo-site/sliders/");
        Assert.assertTrue(sliderPage.isPageOpened(), "Slider Page is not opened");
        SliderColorPage sliderColorPage = new SliderColorPage(getDriver());
        String color = "red";
        Assert.assertTrue(sliderColorPage.isFrameOpened(), "Color picker frame is not opened");
        sliderColorPage.moveSlider(color, 100);
        SliderRangePage sliderRangePage = (SliderRangePage) sliderPage.getMenu()
                .clickOnMenuOption(MenuOptions.RANGE);
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
        Assert.assertTrue(tooltipPage.isPageOpened(), "ToolTip Page is not opened");
        TooltipImagePage tooltipImagePage = new TooltipImagePage(getDriver());
        Assert.assertTrue(tooltipImagePage.isFrameOpened(), "Image frame is not opened");
        String image = "Tower Bridge";
        tooltipImagePage.scrollToImage(image);
        tooltipImagePage.hoverImage(image);
        Assert.assertEquals(tooltipImagePage.getActualToolTip(), image, "Tooltip is not displayed");
        TooltipVideoPage tooltipVideoPage = (TooltipVideoPage) tooltipPage.getMenu()
                .clickOnMenuOption(MenuOptions.VIDEO_BASED);
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
        Assert.assertTrue(progressBarPage.isPageOpened(), "Progress bar page is opened");
        DownloadManagerPage downloadManagerPage = new DownloadManagerPage(getDriver());
        Assert.assertTrue(downloadManagerPage.isFrameOpened(), "Download manager frame is not opened");
        downloadManagerPage.clickDownloadBtn();
        Assert.assertEquals(downloadManagerPage.getProgressBarLabel(), "Starting download...", "Downloading is not started");
        downloadManagerPage.waitForProgressDownload();
        Assert.assertEquals(downloadManagerPage.getProgressBarLabel(), "Complete!", "Downloading is not completed");
        RandomProgressPage randomProgressPage = (RandomProgressPage) progressBarPage.getMenu()
                .clickOnMenuOption(MenuOptions.RANDOM_PROGRESS_BAR);
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
        Assert.assertTrue(framesAndWindowsPage.isPageOpened(), "Frames and windows page is not opened");
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
        Assert.assertTrue(accordionAndTabsPage.isPageOpened(), "Accordion page is opened");
        SimpleAccordionPage simpleAccordionPage = new SimpleAccordionPage(getDriver());
        Assert.assertTrue(simpleAccordionPage.isFrameOpened(), "Simple frame is opened");
        String section = "Section 2";
        simpleAccordionPage.scrollToSection(section);
        simpleAccordionPage.clickSection(section);
        Assert.assertTrue(simpleAccordionPage.isSectionOpened(section), "Section is not opened");
        ResizeAccordionPage resizeAccordionPage = (ResizeAccordionPage) accordionAndTabsPage.getMenu()
                .clickOnMenuOption(MenuOptions.RESIZE_ACCORDION);
        Assert.assertTrue(resizeAccordionPage.isFrameOpened(), "Re-size frame is not opened");
        for (int i = 0; i < resizeAccordionPage.getCountSections(); i++) {
            resizeAccordionPage.clickSection(i);
            Assert.assertTrue(resizeAccordionPage.isSectionTextDisplayed(i), "Section text is not displayed");
        }
    }

    @Test(groups = "Second_step")
    @MethodOwner(owner = "Gigi")
    public void testAutoComplete() throws IncorectMenuException {
        AutoCompletePage autoCompletePage = new AutoCompletePage(getDriver());
        autoCompletePage.openURL("https://www.globalsqa.com/demo-site/auto-complete/");
        Assert.assertTrue(autoCompletePage.isPageOpened(), "Autocomplete page is opened");
        CategoriesPage categoriesPage = new CategoriesPage(getDriver());
        Assert.assertTrue(categoriesPage.isFrameOpened(), "Categories Frame is not opened");
        categoriesPage.typeInSearchTextField("a");
        String searchedText = "anders andersson";
        categoriesPage.clickSearchedText(searchedText);
        Assert.assertEquals(categoriesPage.getPrintedText(), searchedText, "Searched text is not displayed");
        ComboBoxPage comboBoxPage = (ComboBoxPage) autoCompletePage.getMenu()
                .clickOnMenuOption(MenuOptions.COMBO_BOX);
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
        Assert.assertTrue(selectElementsPage.isPageOpened(), "Select Element frame is not opened");
        MultipleSelectionPage multipleSelectionPage = new MultipleSelectionPage(getDriver());
        Assert.assertTrue(multipleSelectionPage.isFrameOpened(), "Multiple Selection frame is not opened");
        String element = "Item 1";
        multipleSelectionPage.clickSectionElement(element);
        Assert.assertTrue(multipleSelectionPage.isSectionSelected(element), "Section element is not selected");
    }
}
