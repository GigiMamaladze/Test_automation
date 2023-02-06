package com.solvd.project.carina.demo.gui.components.tooltip;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TooltipImagePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(TooltipImagePage.class);
    @FindBy(xpath = "//*[@alt='%s']")
    private ExtendedWebElement images;
    @FindBy(xpath = "//*[@rel-title='Image Based']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;
    @FindBy(xpath = "//*[@role='tooltip']/div[@class='ui-tooltip-content']")
    private ExtendedWebElement toolTip;

    public TooltipImagePage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void scrollToImage(String image) {
        driver.switchTo().frame(iframe.getElement());
        images.format(image).scrollTo();
        driver.switchTo().defaultContent();
    }

    public void hoverImage(String image) {
        driver.switchTo().frame(iframe.getElement());
        images.format(image).hover();
        driver.switchTo().defaultContent();
    }

    public String getActualToolTip() {
        driver.switchTo().frame(iframe.getElement());
        String actualToolTip = toolTip.getText();
        LOGGER.info(actualToolTip);
        driver.switchTo().defaultContent();
        return actualToolTip;
    }
}
