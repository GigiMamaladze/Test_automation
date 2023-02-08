package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class FramesAndWindowsPage extends AbstractPage {

    public FramesAndWindowsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@rel-title='Open New Tab']//*[text()='Click Here']")
    private ExtendedWebElement clickHereBtn;

    @Override
    public boolean isPageOpened() {
        return clickHereBtn.isElementPresent();
    }

    public void clickClickHereBtn() {
        clickHereBtn.click();
    }
}
