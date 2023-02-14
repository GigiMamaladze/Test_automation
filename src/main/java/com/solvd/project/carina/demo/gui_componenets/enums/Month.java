package com.solvd.project.carina.demo.gui_componenets.enums;

public enum Month {

    JANUARY(1, "Jan"),
    FEBRUARY(2, "Feb"),
    MARCH(3, "Mar"),
    APRIL(4, "Apr"),
    MAY(5, "May"),
    JUNE(6, "Jun"),
    JULY(7, "Jul"),
    AUGUST(8, "Aug"),
    SEPTEMBER(9, "Sep"),
    OCTOBER(10, "Oct"),
    NOVEMBER(11, "Nov"),
    DECEMBER(12, "Dec");

    private final int monthNumber;

    private final String monthAbbreviate;

    Month(int monthNumber, String monthAbbreviate) {
        this.monthNumber = monthNumber;
        this.monthAbbreviate = monthAbbreviate;
    }

    public String getMonthAbbreviate() {
        return monthAbbreviate;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }
}
