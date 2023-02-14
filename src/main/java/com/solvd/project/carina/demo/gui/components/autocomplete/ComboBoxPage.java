package com.solvd.project.carina.demo.gui.components.autocomplete;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ComboBoxPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='ComboBox']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(css = "input.custom-combobox-input")
    private ExtendedWebElement textField;

    @FindBy(css = "a.custom-combobox-toggle")
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

    public void selectProgramingLanguage(String language) {
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
