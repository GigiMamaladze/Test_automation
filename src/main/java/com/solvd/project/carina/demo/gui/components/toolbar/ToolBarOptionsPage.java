package com.solvd.project.carina.demo.gui.components.toolbar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui_componenets.enums.ZoomPercentage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ToolBarOptionsPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Toolbar']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id = 'page']")
    private ExtendedWebElement page;

    @FindBy(xpath = "//*[@id = 'zoom-button']")
    private ExtendedWebElement zoomButton;

    @FindBy(xpath = "//*[@id = 'zoom-menu']//*[@role = 'option'][text() = '%s']")
    private ExtendedWebElement zoomOptions;

    @FindBy(xpath = "//*[@id = 'fontname-button']")
    private ExtendedWebElement fontNameButton;

    @FindBy(xpath = "//*[@id = 'fontsize-button']")
    private ExtendedWebElement fontSizeButton;

    @FindBy(xpath = "//*[@id = 'hilitecolor-button']")
    private ExtendedWebElement highLightButton;

    @FindBy(xpath = "//*[@id = 'hilitecolor-button']")
    private ExtendedWebElement colorButton;

    public ToolBarOptionsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void clickZoomBtn() {
        driver.switchTo().frame(iframe.getElement());
        zoomButton.click();
        driver.switchTo().defaultContent();
    }

    public void clickZoomPercentage(ZoomPercentage zoomPercentage) {
        driver.switchTo().frame(iframe.getElement());
        zoomOptions.format(zoomPercentage.getZoomPercentage()).click();
        driver.switchTo().defaultContent();
    }

    public boolean isZoomPercentageChanged(ZoomPercentage zoomPercentage) {
        driver.switchTo().frame(iframe.getElement());
        boolean result = page != null && page.getAttribute("style")
                .contains(zoomPercentage.getZoomPercentage());
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isFontSizeButtonPresent() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = fontSizeButton.isElementPresent();
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isHighLightButtonPresent() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = highLightButton.isElementPresent();
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isColorButtonPresent() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = colorButton.isElementPresent();
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isFontNameButtonPresent() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = fontNameButton.isElementPresent();
        driver.switchTo().defaultContent();
        return result;
    }
}
