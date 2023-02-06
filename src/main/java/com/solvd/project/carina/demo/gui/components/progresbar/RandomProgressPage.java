package com.solvd.project.carina.demo.gui.components.progresbar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RandomProgressPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(RandomProgressPage.class);
    @FindBy(xpath = "//*[@rel-title='Random Progress Bar']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;
    @FindBy(xpath = "//*[@id='numButton']")
    private ExtendedWebElement randomValueBtn;
    @FindBy(xpath = "//*[@id='falseButton']")
    private ExtendedWebElement indeterminateBtn;
    @FindBy(xpath = "//*[@id='progressbar']")
    private ExtendedWebElement progressbar;

    public RandomProgressPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void clickRandomValueBtn() {
        driver.switchTo().frame(iframe.getElement());
        randomValueBtn.click();
        driver.switchTo().defaultContent();
    }

    public String getAcctualPercentage() {
        driver.switchTo().frame(iframe.getElement());
        String result = progressbar.getAttribute("aria-valuenow");
        LOGGER.info(result);
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isPercentageChanged(String percentage) {
        driver.switchTo().frame(iframe.getElement());
        boolean result = !progressbar.getAttribute("aria-valuenow").equals(percentage);
        driver.switchTo().defaultContent();
        return result;
    }


    public void clickIndeterminateBtn() {
        driver.switchTo().frame(iframe.getElement());
        indeterminateBtn.click();
        driver.switchTo().defaultContent();
    }
}
