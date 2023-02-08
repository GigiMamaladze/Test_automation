package com.solvd.project.carina.demo.gui.components.accordion;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SimpleAccordionPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Simple Accordion']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[text()='%s']")
    private ExtendedWebElement sections;

    public SimpleAccordionPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void scrollToSection(String section) {
        driver.switchTo().frame(iframe.getElement());
        sections.format(section).scrollTo();
        driver.switchTo().defaultContent();
    }

    public void clickSection(String section) {
        driver.switchTo().frame(iframe.getElement());
        sections.format(section).click();
        driver.switchTo().defaultContent();
    }

    public boolean isSectionOpened(String section) {
        driver.switchTo().frame(iframe.getElement());
        String attribute = sections.format(section).getAttribute("aria-selected");
        boolean result = false;
        if ("true".equals(attribute)) {
            result = true;
        }
        driver.switchTo().defaultContent();
        return result;
    }
}
