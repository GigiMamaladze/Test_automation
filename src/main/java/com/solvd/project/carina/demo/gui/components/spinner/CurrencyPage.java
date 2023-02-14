package com.solvd.project.carina.demo.gui.components.spinner;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui_componenets.enums.Currency;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CurrencyPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Currency']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(css = "a.ui-spinner-up" )
    private ExtendedWebElement spinnerUpBtn;

    @FindBy(css = "a.ui-spinner-down")
    private ExtendedWebElement spinnerDownBtn;

    @FindBy(xpath = "//*[text()='%s']")
    private ExtendedWebElement currencyList;

    @FindBy(xpath = "//*[@id='spinner']")
    private ExtendedWebElement amount;

    public CurrencyPage(WebDriver driver) {
        super(driver);
    }


    public boolean isFrameOpened() {
        return iframe.isElementPresent();
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

    public void selectCurrency(Currency currency) {
        driver.switchTo().frame(iframe.getElement());
        currencyList.format(currency.getCurrency()).click();
        driver.switchTo().defaultContent();
    }

    public String getAmountDonate() {
        driver.switchTo().frame(iframe.getElement());
        String result = amount.getAttribute("value");
        driver.switchTo().defaultContent();
        return result;
    }
}
