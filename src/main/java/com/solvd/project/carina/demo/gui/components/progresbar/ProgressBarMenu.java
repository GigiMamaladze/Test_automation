package com.solvd.project.carina.demo.gui.components.progresbar;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProgressBarMenu extends AbstractUIObject {
    public ProgressBarMenu(WebDriver driver) {
        super(driver);
    }

    public ProgressBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//*[@id='%s']")
    private ExtendedWebElement menuList;

    public void scrollToMenu(){
        menuList.format("Random Progress Bar").scrollTo();
    }
    public RandomProgressFrame clickOnRandomProgressBar(){
        menuList.format("Random Progress Bar").click();
        return new RandomProgressFrame(getDriver());
    }

}
