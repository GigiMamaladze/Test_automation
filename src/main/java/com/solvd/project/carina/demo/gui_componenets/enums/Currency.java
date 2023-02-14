package com.solvd.project.carina.demo.gui_componenets.enums;

public enum Currency {

    US("US $"),
    EUR("EUR €"),
    YEN("YEN ¥");

    private final String currency;

    Currency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
