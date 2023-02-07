package com.solvd.project.carina.demo.gui.components.autocomplete;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoriesPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(CategoriesPage.class);

    @FindBy(xpath = "//*[@rel-title='Categories']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id='search']")
    private ExtendedWebElement searchTextField;

    @FindBy(xpath = "//ul[contains(@id,'ui-id-1')]//*[text()='%s']")
    private ExtendedWebElement searchedText;

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    public void typeInSearchTextField(String text) {
        driver.switchTo().frame(iframe.getElement());
        searchTextField.type(text);
        driver.switchTo().defaultContent();
    }

    public void clickSearchedText(String text) {
        driver.switchTo().frame(iframe.getElement());
        searchedText.format(text).click();
        driver.switchTo().defaultContent();
    }

    public String getPrintedText() {
        driver.switchTo().frame(iframe.getElement());
        String result = searchTextField.getAttribute("value");
        driver.switchTo().defaultContent();
        LOGGER.info(result);
        return result;
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }
}
