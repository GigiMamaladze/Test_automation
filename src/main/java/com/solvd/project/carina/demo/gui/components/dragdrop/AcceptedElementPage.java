package com.solvd.project.carina.demo.gui.components.dragdrop;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AcceptedElementPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Accepted Elements']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id = 'draggable-nonvalid']")
    private ExtendedWebElement nonValidBoxElement;

    @FindBy(xpath = "//*[@id = 'draggable']")
    private ExtendedWebElement draggableBoxElement;

    @FindBy(xpath = "//*[@id = 'droppable']")
    private ExtendedWebElement targetPanel;

    public AcceptedElementPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void moveNonValidElementToTargetPanel() {
        driver.switchTo().frame(iframe.getElement());
        dragAndDrop(nonValidBoxElement, targetPanel);
        driver.switchTo().defaultContent();
    }

    public void moveDraggableBoxElementToTargetPanel() {
        driver.switchTo().frame(iframe.getElement());
        dragAndDrop(draggableBoxElement, targetPanel);
        driver.switchTo().defaultContent();
    }

    public boolean isElementAccepted() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = targetPanel != null && targetPanel.getAttribute("class").contains("highlight");
        driver.switchTo().defaultContent();
        return result;
    }
}
