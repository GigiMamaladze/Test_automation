package com.solvd.project.carina.demo.gui.components.dragdrop;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui_componenets.enums.Image;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PhotoManagerPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Photo Manager']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id = 'gallery']")
    private ExtendedWebElement gallery;

    @FindBy(xpath = "//*[@id = 'trash']")
    private ExtendedWebElement trash;

    @FindBy(xpath = "//*[@id ='gallery']//*[text() = '%s']/..")
    private ExtendedWebElement imageInGallery;

    @FindBy(xpath = "//*[@id ='trash']//*[text() = '%s']/..")
    private ExtendedWebElement imageInTrash;

    @FindBy(xpath = "//*[text() = '%s']/..//*[text()= 'Delete image']")
    private ExtendedWebElement deleteImageBtn;

    @FindBy(xpath = "//*[@id ='trash']//*[text() = '%s']/..//*[text() = 'Recycle image']")
    private ExtendedWebElement recycleImageBtn;

    @FindBy(xpath = "//*[text() = '%s']/..//*[text()='View larger']")
    private ExtendedWebElement viewImageLargerBtn;

    @FindBy(xpath = "//*[@class = 'ui-dialog-title'][text() = '%s']")
    private ExtendedWebElement imageDialogTitle;

    public PhotoManagerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void moveImageToTrash(Image image) {
        driver.switchTo().frame(iframe.getElement());
        dragAndDrop(imageInGallery.format(image.getImageTitle()), trash);
        driver.switchTo().defaultContent();
    }

    public boolean isImageInTrash(Image image) {
        driver.switchTo().frame(iframe.getElement());
        boolean result = imageInTrash.format(image.getImageTitle()).isElementPresent();
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isImageInGallery(Image image) {
        driver.switchTo().frame(iframe.getElement());
        boolean result = imageInGallery.format(image.getImageTitle()).isElementPresent();
        driver.switchTo().defaultContent();
        return result;
    }

    public void moveImageToGallery(Image image) {
        driver.switchTo().frame(iframe.getElement());
        dragAndDrop(imageInTrash.format(image.getImageTitle()), gallery);
        driver.switchTo().defaultContent();
    }

    public void clickDeleteImage(Image image) {
        driver.switchTo().frame(iframe.getElement());
        deleteImageBtn.format(image.getImageTitle()).click();
        driver.switchTo().defaultContent();
    }

    public void clickRecycleImageBtn(Image image) {
        driver.switchTo().frame(iframe.getElement());
        recycleImageBtn.format(image.getImageTitle()).click();
        driver.switchTo().defaultContent();
    }

    public void clickViewImageLargerBtn(Image image) {
        driver.switchTo().frame(iframe.getElement());
        viewImageLargerBtn.format(image.getImageTitle()).click();
        driver.switchTo().defaultContent();
    }

    public boolean isImageDialogTitleDisplayed(Image image) {
        driver.switchTo().frame(iframe.getElement());
        boolean result = imageDialogTitle.format(image.getImageDialogTitle()).isVisible();
        driver.switchTo().defaultContent();
        return result;
    }
}
