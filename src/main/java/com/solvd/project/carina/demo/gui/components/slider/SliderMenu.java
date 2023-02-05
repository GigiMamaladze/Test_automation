package com.solvd.project.carina.demo.gui.components.slider;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SliderMenu extends AbstractUIObject {
    public SliderMenu(WebDriver driver) {
        super(driver);
    }

    public SliderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//*[@id='%s']")
    private ExtendedWebElement menuList;

    public SliderColorFrame clickOnColorPicker(){
        menuList.format("Color Picker").click();
        return new SliderColorFrame(getDriver());
    }

    public SliderRangeFrame clickOnRange(){
        menuList.format("Range").click();
        return new SliderRangeFrame(getDriver());
    }
}
