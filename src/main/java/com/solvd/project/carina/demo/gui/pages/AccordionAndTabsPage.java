package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui.components.FrameTopBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccordionAndTabsPage extends AbstractPage {

    public AccordionAndTabsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='resp-tabs-list ']")
    private FrameTopBarMenu frameTopBarMenu;

    public FrameTopBarMenu getMenu() {
        return frameTopBarMenu;
    }
}
