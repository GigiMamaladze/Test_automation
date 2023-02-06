package com.solvd.project.carina.demo.gui.components.slider;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderRangeFrame extends AbstractPage {
    public SliderRangeFrame(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@rel-title='Range']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id='slider-range']/span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]")
    private ExtendedWebElement leftSlider;

    @FindBy(xpath = "//*[@id='slider-range']/span[@class='ui-slider-handle ui-corner-all ui-state-default'][2]")
    private ExtendedWebElement rightSlider;

    @FindBy(xpath = "//*[@id='slider-range']")
    private ExtendedWebElement range;

    public boolean isFrameOpened(){
        return iframe.isElementPresent();
    }
    public void moveSlider(int percentage, ExtendedWebElement slider){
        driver.switchTo().frame(iframe. getElement ());
        int sliderWidth=slider.getSize().width;
        Actions action = new Actions (getDriver ());
        int offset=(sliderWidth * (percentage/100));
        action.clickAndHold(slider.getElement ()).moveByOffset(offset, 0).release().perform();
        getDriver().switchTo().defaultContent();
    }

    public void moveRightSlider(int percentage){
        moveSlider(percentage,rightSlider);
    }

    public void moveLeftSlider(int percentage){
        moveSlider(percentage,leftSlider);
    }

}
