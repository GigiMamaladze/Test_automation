package com.solvd.project.carina.demo.gui.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui.components.FrameTopBarMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SliderPage extends AbstractPage {
    @FindBy(xpath = "//*[@class='resp-tabs-list ']")
    private FrameTopBarMenu menu;

    public SliderPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return super.isPageOpened();
    }

    public FrameTopBarMenu getSliderMenu() {
        return menu;
    }
}
