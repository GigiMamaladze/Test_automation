package com.solvd.project.carina.demo.gui.components.progresbar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DownloadManagerFrame extends AbstractPage {
    public DownloadManagerFrame(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@rel-title='Download Manager']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id='downloadButton']")
    private ExtendedWebElement downloadButton;

    @FindBy(xpath = "//*[@class ='progress-label']")
    private ExtendedWebElement progressBarLabel;


    public boolean isFrameOpened() {
       return iframe.isElementPresent();
    }

    public String getProgressBarLabel(){
        driver.switchTo().frame(iframe.getElement());
        String result = progressBarLabel.getText();
        driver.switchTo().defaultContent();
        return result;
    }
    public void clickDownloadBtn(){
        driver.switchTo().frame(iframe.getElement());
        downloadButton.click();
        driver.switchTo().defaultContent();
    }

    public void waitToProgressDownload(){
        driver.switchTo().frame(iframe.getElement());
        int count = 0;
        while (!progressBarLabel.getText().equals("Complete!")){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
            if (count >= 30) { // 30 seconds
                break;
            }
        }
        driver.switchTo().defaultContent();
    }

}
