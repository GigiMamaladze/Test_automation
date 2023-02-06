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

    @FindBy(xpath = "//*[@class='tools']")
    private ExtendedWebElement buttonsSection;
    @FindBy(xpath = "//*[@class='tools']//button[contains(text(),'Like')]")
    private ExtendedWebElement likeBtn;

    @FindBy(xpath = "//*[@class='tools']//button[contains(text(),'I dislike this')]")
    private ExtendedWebElement dislikeBtn;

    @FindBy(xpath = "//*[@class='tools']//button[contains(text(),'Add to')]")
    private ExtendedWebElement addToBtn;

    @FindBy(xpath = "//*[@class='tools']//button[contains(text(),'Share')]")
    private ExtendedWebElement shareBtn;
    @FindBy(xpath = "//*[@role='tooltip']/div[@class='ui-tooltip-content']")
    private ExtendedWebElement toolTip;


    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void scrollToButtons() {
        driver.switchTo().frame(iframe.getElement());
        buttonsSection.scrollTo();
        driver.switchTo().defaultContent();
    }

    public void hoverLikeButton() {
        driver.switchTo().frame(iframe.getElement());
        likeBtn.hover();
        driver.switchTo().defaultContent();
    }

    public void hoverAddToBtn() {
        driver.switchTo().frame(iframe.getElement());
        addToBtn.hover();
        driver.switchTo().defaultContent();
    }

    public void hoverShareBtn() {
        driver.switchTo().frame(iframe.getElement());
        shareBtn.hover();
        driver.switchTo().defaultContent();
    }

    public String getActualTooltip() {
        driver.switchTo().frame(iframe.getElement());
        String actualTooltip = toolTip.getText();
        driver.switchTo().defaultContent();
        LOGGER.info(actualTooltip);
        return actualTooltip;
    }

    public String getTitleLikeBtn() {
        driver.switchTo().frame(iframe.getElement());
        String title = likeBtn.getAttribute("title");
        driver.switchTo().defaultContent();
        LOGGER.info(title);
        return title;
    }

    public String getTitleAddToBtn() {
        driver.switchTo().frame(iframe.getElement());
        String title = addToBtn.getAttribute("title");
        driver.switchTo().defaultContent();
        LOGGER.info(title);
        return title;
    }

    public String getTitleShareBtn() {
        driver.switchTo().frame(iframe.getElement());
        String title = shareBtn.getAttribute("title");
        driver.switchTo().defaultContent();
        LOGGER.info(title);
        return title;
    }
}
