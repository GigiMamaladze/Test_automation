package com.solvd.project.carina.demo.gui.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.project.carina.demo.gui.components.progresbar.RandomProgressPage;
import com.solvd.project.carina.demo.gui.components.slider.SliderColorPage;
import com.solvd.project.carina.demo.gui.components.slider.SliderRangePage;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipImagePage;
import com.solvd.project.carina.demo.gui.components.tooltip.TooltipVideoPage;
import com.solvd.project.carina.demo.gui_componenets.enums.MenuOptions;
import com.solvd.project.carina.demo.gui_componenets.exceptions.IncorectMenuException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FrameTopBarMenu extends AbstractUIObject {

    private static final Logger LOGGER = LogManager.getLogger(FrameTopBarMenu.class);

    @FindBy(xpath = "//*[@id='%s']")
    private ExtendedWebElement menuList;

    public FrameTopBarMenu(WebDriver driver) {
        super(driver);
    }

    public FrameTopBarMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Object clickOnMenuOption(MenuOptions menuOptions) throws IncorectMenuException {
        switch (menuOptions) {
            case COLOR_PICKER:
                menuList.format(menuOptions.getMenuName()).scrollTo();
                menuList.format(menuOptions.getMenuName()).click();
                return new SliderColorPage(getDriver());
            case RANGE:
                menuList.format(menuOptions.getMenuName()).scrollTo();
                menuList.format(menuOptions.getMenuName()).click();
                return new SliderRangePage(getDriver());
            case RANDOM_PROGRESS_BAR:
                menuList.format(menuOptions.getMenuName()).scrollTo();
                menuList.format(menuOptions.getMenuName()).click();
                return new RandomProgressPage(getDriver());
            case VIDEO_BASED:
                menuList.format(menuOptions.getMenuName()).scrollTo();
                menuList.format(menuOptions.getMenuName()).click();
                return new TooltipVideoPage(getDriver());
            case IMAGE_BASED:
                menuList.format(menuOptions.getMenuName()).scrollTo();
                menuList.format(menuOptions.getMenuName()).click();
                return new TooltipImagePage(getDriver());
            default:
                    throw new IncorectMenuException("No such Menu is found");
        }
    }
}
