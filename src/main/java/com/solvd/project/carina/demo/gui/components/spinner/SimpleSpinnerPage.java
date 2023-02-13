package com.solvd.project.carina.demo.gui.components.spinner;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SimpleSpinnerPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(SimpleSpinnerPage.class);

    @FindBy(xpath = "//*[@rel-title='Simple Spinner']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id='spinner']")
    private ExtendedWebElement valueField;

    @FindBy(xpath = "//a[contains(@class,'ui-spinner-up')]")
    private ExtendedWebElement spinnerUpBtn;

    @FindBy(xpath = "//a[contains(@class,'ui-spinner-down')]")
    private ExtendedWebElement spinnerDownBtn;

    @FindBy(xpath = "//*[@id='disable']")
    private ExtendedWebElement toggleDisableBtn;

    @FindBy(xpath = "//*[@id='destroy']")
    private ExtendedWebElement toggleWidgetBtn;

    @FindBy(xpath = "//*[@id='getvalue']")
    private ExtendedWebElement getValueBtn;

    @FindBy(xpath = "//*[@id='setvalue']")
    private ExtendedWebElement setValue5Btn;

    public SimpleSpinnerPage(WebDriver driver) {
        super(driver);
    }

    public void clickUpSpinner() {
        driver.switchTo().frame(iframe.getElement());
        spinnerUpBtn.click();
        driver.switchTo().defaultContent();
    }

    public void clickDownSpinner() {
        driver.switchTo().frame(iframe.getElement());
        spinnerDownBtn.click();
        driver.switchTo().defaultContent();
    }

    public String getSelectedValue() {
        driver.switchTo().frame(iframe.getElement());
        String result = valueField.getAttribute("aria-valuenow");
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isSpinnerDisabled() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = spinnerUpBtn.getAttribute("class").contains("disable");
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isSpinnerPresent() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = spinnerUpBtn.isElementPresent(3);
        driver.switchTo().defaultContent();
        return result;
    }

    public void clickToggleDisableBtn() {
        driver.switchTo().frame(iframe.getElement());
        toggleDisableBtn.click();
        driver.switchTo().defaultContent();
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void clickToggleWidgetBtn() {
        driver.switchTo().frame(iframe.getElement());
        toggleWidgetBtn.click();
        driver.switchTo().defaultContent();
    }

    public void clickSetValue5Btn() {
        driver.switchTo().frame(iframe.getElement());
        setValue5Btn.click();
        driver.switchTo().defaultContent();
    }

    public String clickGetValueAndGetAlertText() {
        String alertText = "";
        driver.switchTo().frame(iframe.getElement());
        try {
            getValueBtn.click();
            Alert alert = driver.switchTo().alert();
            alertText = alert.getText();
            LOGGER.info("Alert message: " + alertText);
            alert.accept();
        } catch (UnhandledAlertException e) {
            LOGGER.error(e.getMessage());
        }
        driver.switchTo().defaultContent();
        return alertText;
    }
}


