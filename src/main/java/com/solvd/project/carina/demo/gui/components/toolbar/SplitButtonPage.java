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
    private ExtendedWebElement functionListButton;

    @FindBy(xpath = "//*[@class = 'ui-menu-item']//*[text() = '%s']")
    private ExtendedWebElement functionsList;

    @FindBy(xpath = "//button[text() = 'Run last option']")
    private ExtendedWebElement runLastOptionBtn;

    @FindBy(xpath = "//*[@class = 'output']/li[text()='%s']")
    private ExtendedWebElement output;

    public SplitButtonPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void clickFunctionListBtn() {
        driver.switchTo().frame(iframe.getElement());
        functionListButton.click();
        driver.switchTo().defaultContent();
    }

    public void clickFunction(Function function) {
        driver.switchTo().frame(iframe.getElement());
        functionsList.format(function.getFunction()).click();
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
        boolean result = output.format("Running Last Action...").isElementPresent();
        driver.switchTo().defaultContent();
        return result;
    }
}
