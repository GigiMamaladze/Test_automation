package com.solvd.project.carina.demo.gui.components.select;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectionPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Multiple Selection']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id='selectable']//*[text()='%s']")
    private ExtendedWebElement elements;

    public MultipleSelectionPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void clickElement(String element) {
        driver.switchTo().frame(iframe.getElement());
        elements.format(element).click();
        driver.switchTo().defaultContent();
    }

    public String getAttribute(String element) {
        driver.switchTo().frame(iframe.getElement());
        String result = elements.format(element).getAttribute("class");
        driver.switchTo().defaultContent();
        return result;
    }
}
