package com.solvd.project.carina.demo.gui_componenets.enums;

public enum ZoomPercentage {

    FIFTY("50%"),
    SEVENTY_FIVE("75%"),
    NINETY("90%"),
    HUNDRED("100%"),
    ONE_HUNDRED_TWENTY_FIVE("150%"),
    TWO_HUNDRED("200%");

    private final String zoomPercentage;

    ZoomPercentage(String zoomPercentage) {
        this.zoomPercentage = zoomPercentage;
    }

    public String getZoomPercentage() {
        return zoomPercentage;
    }
}
