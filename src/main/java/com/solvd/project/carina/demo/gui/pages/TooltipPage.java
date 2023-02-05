package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TooltipPage extends AbstractPage {
    public TooltipPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='resp-tabs-list ']")
    private TooltipMenu menu;
    @Override
    public boolean isPageOpened() {
        return super.isPageOpened();
    }

    public TooltipMenu getMenu() {
        return menu;
    }
}
