package com.solvd.project.carina.demo.gui.components.tooltip;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TooltipVideoPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Video Based']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@class='tools']")
    private ExtendedWebElement buttonsSection;
    @FindBy(xpath = "//*[@class='tools']//button[text()='Like']")
    private ExtendedWebElement likeBtn;

    @FindBy(xpath = "//*[@class='tools']//button[text()='I dislike this']")
    private ExtendedWebElement dislikeBtn;

    @FindBy(xpath = "//*[@class='tools']//button[text()='Add to']")
    private ExtendedWebElement addToBtn;

    @FindBy(xpath = "//*[@class='tools']//button[text()='Share']")
    private ExtendedWebElement shareBtn;
    @FindBy(xpath = "//*[@role='tooltip']/div[@class='ui-tooltip-content']")
    private ExtendedWebElement toolTip;

    public TooltipVideoPage(WebDriver driver) {
        super(driver);
    }


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

    public boolean isTooltipDisplayed() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = toolTip.isVisible();
        driver.switchTo().defaultContent();
        return result;
    }
}
