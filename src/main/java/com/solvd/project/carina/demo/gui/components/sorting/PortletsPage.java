package com.solvd.project.carina.demo.gui.components.sorting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PortletsPage extends AbstractPage {

    private static final Logger LOGGER = LogManager.getLogger(PortletsPage.class);

    @FindBy(xpath = "//*[@rel-title='Portlets']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@class='portlet ui-widget ui-widget-content ui-helper-clearfix ui-corner-all']/div[text()='%s']")
    private ExtendedWebElement portlets;

    public PortletsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void movePortlets(String from, String to) {
        driver.switchTo().frame(iframe.getElement());
        ExtendedWebElement sourcePortlet = portlets.format(from);
        ExtendedWebElement targetPortlet = portlets.format(to);
        Point target = targetPortlet.getLocation();
        Point source = sourcePortlet.getLocation();
        LOGGER.info("Target " + target);
        LOGGER.info("source " + source);
        int x = target.getX() - source.getX();
        int y;
        if (x == 0 && target.getY() < source.getY()) {
            y = target.getY() - source.getY();
        } else if (x != 0 && target.getY() < source.getY()) {
            y = target.getY() - source.getY() - target.getY() * 2;
        } else if (x == 0 && target.getY() > source.getY()) {
            y = target.getY() + source.getY() + sourcePortlet.getSize().getHeight();
        } else {
            y = target.getY() - source.getY() - sourcePortlet.getSize().getHeight();
        }
        LOGGER.info("X = " + x + "Y = " + y);
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(portlets.format(from).getElement(), x, y).build().perform();
        driver.switchTo().defaultContent();
    }

    public Point getLocationPortlet(String portlet) {
        driver.switchTo().frame(iframe.getElement());
        Point result = portlets.format(portlet).getLocation();
        driver.switchTo().defaultContent();
        return result;
    }
}
