package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui.components.slider.SliderMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends AbstractPage {
    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return super.isPageOpened();
    }

    @FindBy(xpath = "//*[@class='resp-tabs-list ']")
    private SliderMenu sliderMenu;

    public SliderMenu getSliderMenu() {
        return sliderMenu;
    }
}
