package com.solvd.project.carina.demo.gui.components.sorting;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui_componenets.enums.ItemList;
import com.solvd.project.carina.demo.gui_componenets.enums.ItemType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MultipleListsPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Multiple Lists']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//li[@class ='ui-state-default ui-sortable-handle'][text() = 'Item %s']")
    private ExtendedWebElement whiteItem;

    @FindBy(xpath = "//li[@class ='ui-state-highlight ui-sortable-handle'][text() = 'Item %s']")
    private ExtendedWebElement yellowItem;

    @FindBy(xpath = "//*[@id = 'sortable1']")
    private ExtendedWebElement leftList;

    @FindBy(xpath = "//*[@id = 'sortable2']")
    private ExtendedWebElement rightList;

    public MultipleListsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void moveItemToList(int item, ItemType itemType, ItemList itemList) {
        driver.switchTo().frame(iframe.getElement());
        ExtendedWebElement itemToMove = itemType.equals(ItemType.WHITE) ? whiteItem.format(item) : yellowItem.format(item);
        ExtendedWebElement destinationList = itemList.equals(ItemList.LEFT) ? leftList : rightList;
        dragAndDrop(itemToMove, destinationList);
        driver.switchTo().defaultContent();
    }

    public Point getItemLocation(ItemType itemType, int item) {
        driver.switchTo().frame(iframe.getElement());
        Point result = itemType.equals(ItemType.WHITE) ? whiteItem.format(item).getLocation() : yellowItem.format(item).getLocation();
        driver.switchTo().defaultContent();
        return result;
    }
}
