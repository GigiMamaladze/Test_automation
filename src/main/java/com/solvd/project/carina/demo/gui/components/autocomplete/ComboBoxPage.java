package com.solvd.project.carina.demo.gui.components.autocomplete;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ComboBoxPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='ComboBox']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@class='custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left ui-autocomplete-input']")
    private ExtendedWebElement textField;

    @FindBy(xpath = "//*[@class='ui-button-icon ui-icon ui-icon-triangle-1-s']")
    private ExtendedWebElement showAllItemBtn;

    @FindBy(xpath = "//ul[contains(@id,'ui-id-1')]//*[text()='Java']")
    private ExtendedWebElement programingLanguages;

    public ComboBoxPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void clickShowAllItemBtn() {
        driver.switchTo().frame(iframe.getElement());
        showAllItemBtn.click();
        driver.switchTo().defaultContent();
    }

    public void choseProgramingLanguage(String language) {
        driver.switchTo().frame(iframe.getElement());
        programingLanguages.format(language).click();
        driver.switchTo().defaultContent();
    }

    public String getSelectedLanguage() {
        driver.switchTo().frame(iframe.getElement());
        String result = textField.getAttribute("value");
        driver.switchTo().defaultContent();
        return result;
    }
}