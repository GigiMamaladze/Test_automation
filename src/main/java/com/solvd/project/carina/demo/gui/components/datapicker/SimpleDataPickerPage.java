package com.solvd.project.carina.demo.gui.components.datapicker;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.project.carina.demo.gui_componenets.enums.Month;
import com.solvd.project.carina.demo.gui_componenets.exceptions.IncorectDayException;
import com.solvd.project.carina.demo.gui_componenets.exceptions.IncorectYearException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

public class SimpleDataPickerPage extends AbstractPage {

    @FindBy(xpath = "//*[@rel-title='Simple Date Picker']//*[@class='demo-frame lazyloaded']")
    private ExtendedWebElement iframe;

    @FindBy(xpath = "//*[@id='datepicker']")
    private ExtendedWebElement dataField;

    @FindBy(xpath = "//*[@data-handler='next']")
    private ExtendedWebElement nextArrowBtn;

    @FindBy(xpath = "//*[@data-handler='prev']")
    private ExtendedWebElement previousArrowBtn;

    @FindBy(css = "span.ui-datepicker-month")
    private ExtendedWebElement monthLabel;

    @FindBy(css = "span.ui-datepicker-year")
    private ExtendedWebElement yearLabel;

    @FindBy(xpath = "//*[@class='ui-state-default'][text()='%s']")
    private ExtendedWebElement days;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']")
    private ExtendedWebElement calendar;

    public SimpleDataPickerPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFrameOpened() {
        return iframe.isElementPresent();
    }

    public void clickDataField() {
        driver.switchTo().frame(iframe.getElement());
        dataField.click();
        driver.switchTo().defaultContent();
    }

    public void choseMonthAndYear(Month targetMonth, int targetYear) throws IncorectYearException {
        driver.switchTo().frame(iframe.getElement());
        if (targetYear > 1990) {
            LocalDate currentDate = LocalDate.now();
            int currentMonth = currentDate.getMonthValue();
            int currentYear = currentDate.getYear();
            int targetMonthValue = targetMonth.getMonthNumber() + 12 * (targetYear - currentYear);
            int monthDifference = targetMonthValue - currentMonth;
            ExtendedWebElement arrowBtn = (monthDifference > 0) ? nextArrowBtn : previousArrowBtn;
            for (int i = 0; i < Math.abs(monthDifference); i++) {
                arrowBtn.click();
            }
        } else {
            throw new IncorectYearException("Year is not passed correctly");
        }
        driver.switchTo().defaultContent();
    }

    public String getMonthLabel() {
        driver.switchTo().frame(iframe.getElement());
        String result = monthLabel.getText();
        driver.switchTo().defaultContent();
        return result;
    }

    public String getYearLabel() {
        driver.switchTo().frame(iframe.getElement());
        String result = yearLabel.getText();
        driver.switchTo().defaultContent();
        return result;
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

    public boolean isDayPresent(int day) {
        driver.switchTo().frame(iframe.getElement());
        boolean result = days.format(day).isVisible();
        driver.switchTo().defaultContent();
        return result;
    }

    public String getActualDate() {
        driver.switchTo().frame(iframe.getElement());
        String result = dataField.getAttribute("value");
        driver.switchTo().defaultContent();
        return result;
    }

    public boolean isCalendarPresent() {
        driver.switchTo().frame(iframe.getElement());
        boolean result = calendar.isVisible();
        driver.switchTo().defaultContent();
        return result;
    }
}
