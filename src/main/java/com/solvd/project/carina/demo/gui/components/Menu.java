package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.gui.components.progresbar.RandomProgressFrame;
import com.solvd.project.carina.demo.gui.components.slider.SliderColorFrame;
import com.solvd.project.carina.demo.gui.components.slider.SliderRangeFrame;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipImageFrame;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipVideoFrame;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Menu extends AbstractUIObject {
    public Menu(WebDriver driver) {
        super(driver);
    }

    public Menu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//*[@id='%s']")
    private ExtendedWebElement menuList;

    public RandomProgressFrame clickOnRandomProgressBar(){
        menuList.format("Random Progress Bar").scrollTo();
        menuList.format("Random Progress Bar").click();
        return new RandomProgressFrame(getDriver());
    }

    public SliderColorFrame clickOnColorPicker(){
        menuList.format("Color Picker").click();
        return new SliderColorFrame(getDriver());
    }

    public SliderRangeFrame clickOnRange(){
        menuList.format("Range").click();
        return new SliderRangeFrame(getDriver());
    }
    public TooltipImageFrame clickOnImageFrame(){
        menuList.format("Image Based").scrollTo();
        menuList.format("Image Based").click();
        return new TooltipImageFrame(getDriver());
    }

    public TooltipVideoFrame clickOnVideoBased(){
        menuList.format("Video Based").scrollTo();
        menuList.format("Video Based").click();
        return new TooltipVideoFrame(getDriver());
    }
}
