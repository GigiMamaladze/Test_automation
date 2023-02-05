package com.solvd.project.carina.demo.gui.components.progresbar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RandomProgressFrame extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(RandomProgressFrame.class);
    public RandomProgressFrame(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@rel-title='Random Progress Bar']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id='%s']")
    private ExtendedWebElement buttons;

    @FindBy(xpath = "//*[@id='progressbar']")
    private ExtendedWebElement progressbar;

    @Override
    public boolean isPageOpened() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = progressbar.isElementPresent();
        driver.switchTo().defaultContent();
        return result;
    }

    public void clickOnRandomValueBtn(){
        driver.switchTo().frame(iframe.getElement());
        buttons.format("numButton").click();
        driver.switchTo().defaultContent();
    }
    public String acctualPercentage(){
        driver.switchTo().frame(iframe.getElement());
        String result = progressbar.getAttribute("aria-valuenow");
        LOGGER.info(result);
        driver.switchTo().defaultContent();
        return result;
    }

    public String getRandomPercentage(){
        driver.switchTo().frame(iframe.getElement());
        String result=progressbar.getAttribute("aria-valuenow");
        driver.switchTo().defaultContent();
        return result;
    }

    public void clickOnIndeterminateBtn(){
        driver.switchTo().frame(iframe.getElement());
        buttons.format("falseButton").click();
        driver.switchTo().defaultContent();
    }
}
