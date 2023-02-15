package com.solvd.project.carina.demo.gui.components.draggablebox;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SimpleDragPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Simple Drag']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id = 'draggable']")
    private ExtendedWebElement box;

    public SimpleDragPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void moveBox(int xOffset, int yOffset) {
        driver.switchTo().frame(iframe.getElement());
        Actions actions = new Actions(getDriver());
        actions.dragAndDropBy(box.getElement(), xOffset, yOffset).build().perform();
        driver.switchTo().defaultContent();
    }

    public Point getLocationOfBox() {
        driver.switchTo().frame(iframe.getElement());
        Point result = box.getLocation();
        driver.switchTo().defaultContent();
        return result;
    }
}
