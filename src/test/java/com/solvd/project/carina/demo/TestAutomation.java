package com.solvd.project.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.project.carina.demo.gui.components.progresbar.DownloadManagerPage;
import com.solvd.project.carina.demo.gui.components.progresbar.RandomProgressPage;
import com.solvd.project.carina.demo.gui.components.slider.SliderColorPage;
import com.solvd.project.carina.demo.gui.components.slider.SliderRangePage;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipImagePage;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipVideoPage;
import com.solvd.project.carina.demo.gui.pages.ProgressBarPage;
import com.solvd.project.carina.demo.gui.pages.SliderPage;
import com.solvd.project.carina.demo.gui.pages.TooltipPage;
import com.solvd.project.carina.demo.gui_componenets.enums.MenuOptionsEnum;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAutomation implements IAbstractTest {

    @Test(groups = "First_step")
    @MethodOwner(owner = "Gigi")
    @Description("Only working clearly slider which have one handle")
    public void testSliders() {
        SliderPage sliderPage = new SliderPage(getDriver());
        sliderPage.openURL("https://www.globalsqa.com/demo-site/sliders/");
        Assert.assertTrue(sliderPage.isPageOpened(), "Slider Page is not opened");
        SliderColorPage sliderColorPage = new SliderColorPage(getDriver());
        String color = "red";
        Assert.assertTrue(sliderColorPage.isFrameOpened(), "Color picker frame is not opened");
        sliderColorPage.moveSlider(color, 100);
        SliderRangePage sliderRangePage = (SliderRangePage) sliderPage.getSliderMenu().clickOnMenu(MenuOptionsEnum.RANGE);
        Assert.assertTrue(sliderRangePage.isFrameOpened(), "Range frame is not opened");
        String beforeMoveHandle = sliderRangePage.getHandlesRange();
        sliderRangePage.moveRightSlider(1000);
        sliderRangePage.moveLeftSlider(2000);
        String afterMoveHande = sliderRangePage.getHandlesRange();
        Assert.assertNotEquals(beforeMoveHandle, afterMoveHande);

    }

    @Test(groups = "First_step")
    @MethodOwner(owner = "Gigi")
    public void testTooltip() {
        TooltipPage tooltipPage = new TooltipPage(getDriver());
        tooltipPage.openURL("https://www.globalsqa.com/demo-site/tooltip/");
        Assert.assertTrue(tooltipPage.isPageOpened(), "ToolTip Page is not opened");
        TooltipImagePage tooltipImagePage = new TooltipImagePage(getDriver());
        Assert.assertTrue(tooltipImagePage.isFrameOpened(), "Image frame is not opened");
        String image = "Tower Bridge";
        tooltipImagePage.scrollToImage(image);
        tooltipImagePage.hoverImage(image);
        Assert.assertEquals(tooltipImagePage.getActualToolTip(), image);
        TooltipVideoPage tooltipVideoPage = (TooltipVideoPage) tooltipPage.getMenu().clickOnMenu(MenuOptionsEnum.VIDEO_BASED);
        Assert.assertTrue(tooltipVideoPage.isFrameOpened(), "Video based frame is not opened");
        tooltipVideoPage.scrollToButtons();
        tooltipVideoPage.hoverLikeButton();
        Assert.assertTrue(tooltipVideoPage.isTooltipDisplayed(), "Tool tip is not displayed");
    }

    @Test(groups = "First_step")
    @MethodOwner(owner = "Gigi")
    public void testProgressBar() {
        ProgressBarPage progressBarPage = new ProgressBarPage(getDriver());
        progressBarPage.openURL("https://www.globalsqa.com/demo-site/progress-bar/");
        Assert.assertTrue(progressBarPage.isPageOpened(), "Progress bar page is opened");
        DownloadManagerPage downloadManagerPage = new DownloadManagerPage(getDriver());
        Assert.assertTrue(downloadManagerPage.isFrameOpened(), "Download manager frame is not opened");
        downloadManagerPage.clickDownloadBtn();
        Assert.assertEquals(downloadManagerPage.getProgressBarLabel(), "Starting download...");
        downloadManagerPage.waitForProgressDownload();
        Assert.assertEquals(downloadManagerPage.getProgressBarLabel(), "Complete!");
        RandomProgressPage randomProgressPage = (RandomProgressPage) progressBarPage.getMenu().clickOnMenu(MenuOptionsEnum.RANDOM_PROGRESS_BAR);
        Assert.assertTrue(randomProgressPage.isFrameOpened(), "Random Progress frame is not opened");
        String indeterminatePercentage = randomProgressPage.getAcctualPercentage();
        randomProgressPage.clickRandomValueBtn();
        Assert.assertTrue(randomProgressPage.isPercentageChanged(indeterminatePercentage), "Progress bar is not changed");
        randomProgressPage.clickIndeterminateBtn();
        Assert.assertEquals(randomProgressPage.getAcctualPercentage(), null);
    }
}
