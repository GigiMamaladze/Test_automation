package com.solvd.project.carina.demo.gui_componenets.enums;

public enum Currencies {

    US("US $"),
    EUR("EUR €"),
    YEN("YEN ¥");

    private final String currency;

    Currencies(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }
}
