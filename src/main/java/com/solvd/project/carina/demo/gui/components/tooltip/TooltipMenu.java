package com.solvd.project.carina.demo.gui.components.tooltip;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TooltipMenu extends AbstractUIObject {
    public TooltipMenu(WebDriver driver) {
        super(driver);
    }

    public TooltipMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    @FindBy(xpath = "//*[@id='%s']")
    private ExtendedWebElement menuList;

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
