package com.solvd.project.carina.demo.gui_componenets.utils;

import com.solvd.project.carina.demo.gui_componenets.enums.Month;

public class DataFormatUtil {

    public static String formatToDate(Month month, int day, int year) {
        return String.format("%02d/%02d/%04d", month.getMonthNumber(), day, year);
    }
}
