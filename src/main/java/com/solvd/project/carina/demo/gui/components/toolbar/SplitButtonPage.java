package com.solvd.project.carina.demo.gui.components.toolbar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui_componenets.enums.Function;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SplitButtonPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='SplitButton']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id = 'ui-id-1-button']")
    private ExtendedWebElement functionArrowButton;

    @FindBy(xpath = "//*[@class = 'ui-menu-item']//*[text() = '%s']")
    private ExtendedWebElement functionInList;

    @FindBy(xpath = "//button[text() = 'Run last option']")
    private ExtendedWebElement runLastOptionBtn;

    @FindBy(xpath = "//*[@class = 'output']/li[text()='%s']")
    private ExtendedWebElement output;

    @FindBy(xpath = "//*[@class = 'output']/li[text()='Running Last Action...']")
    private ExtendedWebElement runningLastOptionMessage;

    public SplitButtonPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void clickFunctionArrowBtn() {
        driver.switchTo().frame(iframe.getElement());
        functionArrowButton.click();
        driver.switchTo().defaultContent();
    }

    public void clickFunction(Function function) {
        driver.switchTo().frame(iframe.getElement());
        functionInList.format(function.getFunction()).click();
        driver.switchTo().defaultContent();
    }

    public void clickRunLastOptionBtn() {
        driver.switchTo().frame(iframe.getElement());
        runLastOptionBtn.click();
        driver.switchTo().defaultContent();
    }

    public boolean isFunctionPresentInOutput(Function function) {
        driver.switchTo().frame(iframe.getElement());
        boolean result = output.format(function.getFunction()).isElementPresent();
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isRunLastOptionPresentInOutput() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = runningLastOptionMessage.isElementPresent();
        driver.switchTo().defaultContent();
        return result;
    }
}
