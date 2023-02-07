package com.solvd.project.carina.demo.gui.components.select;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MultipleSelectionPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Multiple Selection']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id='selectable']//*[text()='%s']")
    private ExtendedWebElement sectionElements;

    public MultipleSelectionPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void clickSectionElement(String sectionElement) {
        driver.switchTo().frame(iframe.getElement());
        sectionElements.format(sectionElement).click();
        driver.switchTo().defaultContent();
    }

    public String getClassAttribute(String sectionElement) {
        driver.switchTo().frame(iframe.getElement());
        String result = sectionElements.format(sectionElement).getAttribute("class");
        driver.switchTo().defaultContent();
        return result;
    }
}
