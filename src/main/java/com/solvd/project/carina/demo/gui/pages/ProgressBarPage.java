package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui.components.progresbar.ProgressBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPage extends AbstractPage {
    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='resp-tabs-list ']")
    private ProgressBarMenu menu;

    public ProgressBarMenu getMenu() {
        return menu;
    }
}
