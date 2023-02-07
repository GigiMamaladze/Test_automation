package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;
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

    public void clickOnClickHereBtn(){
        clickHereBtn.click();
    }

    public Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }
}
