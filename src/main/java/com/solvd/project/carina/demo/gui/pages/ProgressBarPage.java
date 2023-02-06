package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui.components.FrameTopBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProgressBarPage extends AbstractPage {
    @FindBy(xpath = "//*[@class='resp-tabs-list ']")
    private FrameTopBarMenu frameTopBarMenu;

    public ProgressBarPage(WebDriver driver) {
        super(driver);
    }

    public FrameTopBarMenu getMenu() {
        return frameTopBarMenu;
    }
}
