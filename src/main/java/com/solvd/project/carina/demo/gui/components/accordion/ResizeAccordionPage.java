package com.solvd.project.carina.demo.gui.components.accordion;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResizeAccordionPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Re-Size Accordion']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id='accordion-resizer']//*[@id='accordion']//h3[contains(text(),'Section')]")
    private List<ExtendedWebElement> sections;

    @FindBy(xpath = "//*[@id='accordion-resizer']//*[@id='accordion']/div[contains(@class,'ui-corner-bottom')]")
    private List<ExtendedWebElement> sectionsTexts;

    public ResizeAccordionPage(WebDriver driver) {
        super(driver);
    }

    public void clickSection(int index) {
        driver.switchTo().frame(iframe.getElement());
        sections.get(index).click();
        driver.switchTo().defaultContent();
    }

    public boolean isSectionTextDisplayed(int index) {
        driver.switchTo().frame(iframe.getElement());
        boolean result = sectionsTexts.get(index).isVisible();
        driver.switchTo().defaultContent();
        return result;
    }

    public int getSectionsCount() {
        driver.switchTo().frame(iframe.getElement());
        int result = sectionsTexts.size();
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }
}
