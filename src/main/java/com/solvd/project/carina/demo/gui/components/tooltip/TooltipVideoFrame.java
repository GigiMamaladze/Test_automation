package com.solvd.project.carina.demo.gui.components.tooltip;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TooltipVideoFrame extends AbstractPage {
    private static final Logger LOGGER = LogManager.getLogger(TooltipImageFrame.class);

    public TooltipVideoFrame(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@rel-title='Video Based']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@class='tools']//button[contains(text(),'%s')]")
    private ExtendedWebElement buttons;

    @FindBy(xpath = "//*[@role='tooltip']/div[@class='ui-tooltip-content']")
    private ExtendedWebElement toolTip;


    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void scrollToButton(String button){
        driver.switchTo().frame(iframe.getElement());
        buttons.format(button).scrollTo();
        driver.switchTo().defaultContent();
    }

    public void hoverButton(String button){
        driver.switchTo().frame(iframe.getElement());
        buttons.format(button).hover();
        driver.switchTo().defaultContent();
    }

    public String actualTooltip(){
        driver.switchTo().frame(iframe.getElement());
        String actualTooltip=toolTip.getText();
        driver.switchTo().defaultContent();
        LOGGER.info(actualTooltip);
        return actualTooltip;
    }

    public String getTitleOfButton(String button){
        driver.switchTo().frame(iframe.getElement());
        String title=buttons.format(button).getAttribute("title");
        driver.switchTo().defaultContent();
        LOGGER.info(title);
        return title;
    }

}
