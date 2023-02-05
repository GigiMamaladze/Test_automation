package com.solvd.project.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.project.carina.demo.gui.components.progresbar.DownloadManagerFrame;
import com.solvd.project.carina.demo.gui.components.progresbar.RandomProgressFrame;
import com.solvd.project.carina.demo.gui.components.slider.SliderColorFrame;
import com.solvd.project.carina.demo.gui.components.slider.SliderRangeFrame;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipImageFrame;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipVideoFrame;
import com.solvd.project.carina.demo.gui.pages.ProgressBarPage;
import com.solvd.project.carina.demo.gui.pages.SliderPage;
import com.solvd.project.carina.demo.gui.pages.TooltipPage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAutomation implements IAbstractTest {
    @Test
    @MethodOwner(owner = "Gigi")
    @Description("Only working clearly slider which have one handle")
    public void testSliders(){
        SliderPage sliderPage = new SliderPage(getDriver());
        sliderPage.openURL("https://www.globalsqa.com/demo-site/sliders/");
        Assert.assertTrue(sliderPage.isPageOpened(),"Slider Page is not opened");
        SliderColorFrame sliderColorFrame=new SliderColorFrame(getDriver());
        String color="red";
        Assert.assertTrue(sliderColorFrame.isSliderPresent(color),"Color picker frame is not opened");
        sliderColorFrame.moveSlider(color,100);
        SliderRangeFrame sliderRangeFrame = sliderPage.getSliderMenu().clickOnRange();
        Assert.assertTrue(sliderRangeFrame.isSliderRangePresent(),"Range frame is not opened");
        sliderRangeFrame.moveRightSlider(1000);
        sliderRangeFrame.moveLeftSlider(2000);
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void testTooltip(){
        TooltipPage tooltipPage = new TooltipPage(getDriver());
        tooltipPage.openURL("https://www.globalsqa.com/demo-site/tooltip/");
        Assert.assertTrue(tooltipPage.isPageOpened(),"ToolTip Page is not opened");
        TooltipImageFrame tooltipImageFrame = new TooltipImageFrame(getDriver());
        String image="Tower Bridge";
        tooltipImageFrame.scrollToImage(image);
        tooltipImageFrame.hoverImage(image);
        Assert.assertEquals(tooltipImageFrame.actualToolTip(),image);
        TooltipVideoFrame tooltipVideoFrame = tooltipPage.getMenu().clickOnVideoBased();
        String button ="Share";
        pause(1);
        Assert.assertTrue(tooltipVideoFrame.isPageOpened(),"Video based frame is not opened");
        String title=tooltipVideoFrame.getTitleOfButton(button);
        tooltipVideoFrame.scrollToButton(button);
        tooltipVideoFrame.hoverButton(button);
        Assert.assertEquals(tooltipVideoFrame.actualTooltip(),title);
    }

    @Test
    @MethodOwner(owner = "Gigi")
    public void testProgressBar(){
        ProgressBarPage progressBarPage = new ProgressBarPage(getDriver());
        progressBarPage.openURL("https://www.globalsqa.com/demo-site/progress-bar/");
        Assert.assertTrue(progressBarPage.isPageOpened(),"Progress bar page is opened");
        DownloadManagerFrame downloadManagerFrame = new DownloadManagerFrame(getDriver());
        Assert.assertTrue(downloadManagerFrame.isPageOpened(),"Download manager is not opened");
        downloadManagerFrame.clickOnDownloadBtn();
        Assert.assertEquals(downloadManagerFrame.getProgressBarLabel(),"Starting download...");
        downloadManagerFrame.waitToProgressDownload();
        Assert.assertEquals(downloadManagerFrame.getProgressBarLabel(),"Complete!");
        progressBarPage.getMenu().scrollToMenu();
        RandomProgressFrame randomProgressFrame = progressBarPage.getMenu().clickOnRandomProgressBar();
        pause(1);
        Assert.assertTrue(randomProgressFrame.isPageOpened(),"Random Progress frame is not opened");
        randomProgressFrame.clickOnRandomValueBtn();
        Assert.assertEquals(randomProgressFrame.acctualPercentage(),randomProgressFrame.getRandomPercentage());
        randomProgressFrame.clickOnIndeterminateBtn();
        Assert.assertEquals(randomProgressFrame.acctualPercentage(),null);
    }
}
