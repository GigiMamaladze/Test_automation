package com.solvd.project.carina.demo.gui.components.draggablebox;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckEventsPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Check Events']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id = 'draggable']")
    private ExtendedWebElement box;

    @FindBy(xpath = "//*[@id = 'event-start']/span[contains(@class, 'count')]")
    private ExtendedWebElement startEventValue;

    @FindBy(xpath = "//*[@id = 'event-drag']/span[contains(@class, 'count')]")
    private ExtendedWebElement dragEventValue;

    @FindBy(xpath = "//*[@id = 'event-stop']/span[contains(@class, 'count')]")
    private ExtendedWebElement eventStopValue;

    public CheckEventsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public String getStartInvokeValue() {
        driver.switchTo().frame(iframe.getElement());
        String result = startEventValue.getText();
        driver.switchTo().defaultContent();
        return result;
    }

    public String getDragInvolveValue() {
        driver.switchTo().frame(iframe.getElement());
        String result = dragEventValue.getText();
        driver.switchTo().defaultContent();
        return result;
    }

    public String getStopInvokeValue() {
        driver.switchTo().frame(iframe.getElement());
        String result = eventStopValue.getText();
        driver.switchTo().defaultContent();
        return result;
    }

    public void moveBox(int xOffset, int yOffset) {
        driver.switchTo().frame(iframe.getElement());
        Actions actions = new Actions(getDriver());
        actions.dragAndDropBy(box.getElement(), xOffset, yOffset).build().perform();
        driver.switchTo().defaultContent();
    }
}
