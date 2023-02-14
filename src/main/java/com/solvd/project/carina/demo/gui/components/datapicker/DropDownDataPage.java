package com.solvd.project.carina.demo.gui.components.datapicker;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui_componenets.enums.Month;
import com.solvd.project.carina.demo.gui_componenets.exceptions.IncorectDayException;
import com.solvd.project.carina.demo.gui_componenets.exceptions.IncorectYearException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DropDownDataPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='DropDown DatePicker']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id='datepicker']")
    private ExtendedWebElement dataField;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']")
    private ExtendedWebElement calendar;

    @FindBy(css = "select.ui-datepicker-month")
    private ExtendedWebElement monthSelector;

    @FindBy(css = "select.ui-datepicker-year")
    private ExtendedWebElement yearSelector;

    @FindBy(xpath = "//*[@class='ui-state-default'][text()='%s']")
    private ExtendedWebElement days;

    public DropDownDataPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public boolean isCalendarPresent() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = calendar.isVisible();
        driver.switchTo().defaultContent();
        return result;
    }

    public void clickDataField() {
        driver.switchTo().frame(iframe.getElement());
        dataField.click();
        driver.switchTo().defaultContent();
    }

    public void selectMonth(Month month) {
        driver.switchTo().frame(iframe.getElement());
        monthSelector.select(month.getMonthAbbreviate());
        driver.switchTo().defaultContent();
    }

    public void selectYear(int year) throws IncorectYearException {
        if (year < 2013 || year > 2033) {
            throw new IncorectYearException("Year is not present");
        } else {
            driver.switchTo().frame(iframe.getElement());
            yearSelector.select(String.valueOf(year));
            driver.switchTo().defaultContent();
        }
    }

    public void clickDay(int day) throws IncorectDayException {
        if (day < 0 || day > 31) {
            throw new IncorectDayException("This day does not correspond to calendar days");
        } else {
            driver.switchTo().frame(iframe.getElement());
            days.format(day).click();
            driver.switchTo().defaultContent();
        }
    }

    public String getActualDate() {
        driver.switchTo().frame(iframe.getElement());
        String result = dataField.getAttribute("value");
        driver.switchTo().defaultContent();
        return result;
    }
}
