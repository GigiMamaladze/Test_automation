package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui.components.Menu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TooltipPage extends AbstractPage {
    public TooltipPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='resp-tabs-list ']")
    private Menu menu;
    @Override
    public boolean isPageOpened() {
        return super.isPageOpened();
    }

    public Menu getMenu() {
        return menu;
    }
}
