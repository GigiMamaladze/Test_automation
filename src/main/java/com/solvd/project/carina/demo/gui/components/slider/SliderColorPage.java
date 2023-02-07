package com.solvd.project.carina.demo.gui.components.slider;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SliderColorPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Color Picker']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;
    @FindBy(xpath = "//*[@id='%s']/span")
    private ExtendedWebElement slider;
    @FindBy(xpath = "//*[@id='%s']")
    private ExtendedWebElement handle;

    public SliderColorPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void scrollToSlider(String color) {
        driver.switchTo().frame(iframe.getElement());
        slider.format(color).scrollTo();
        getDriver().switchTo().defaultContent();
    }

    public void moveSlider(String color, int percentage) {
        driver.switchTo().frame(iframe.getElement());
        int sliderWidth = slider.format(color).getSize().width;
        int handleWidth = handle.format(color).getSize().width;
        int offset = (percentage * (sliderWidth - handleWidth)) / 100;
        Actions actions = new Actions(driver);
        actions.clickAndHold(slider.format(color).getElement()).moveByOffset(offset, 0).release().perform();
        getDriver().switchTo().defaultContent();
    }
}
