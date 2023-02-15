package com.solvd.project.carina.demo.gui_componenets.enums;

public enum Image {

    HIGH_TATRAS("High Tatras", "The peaks of High Tatras"),
    HIGH_TATRAS_2("High Tatras 2", "The chalet at the Green mountain lake"),
    HIGH_TATRAS_3("High Tatras 3", "Planning the ascent"),
    HIGH_TATRAS_4("High Tatras 4", "On top of Kozi kopka");

    private final String imageDialogTitle;

    private final String imageTitle;

    Image(String imageTitle, String imageDialogTitle) {
        this.imageTitle = imageTitle;
        this.imageDialogTitle = imageDialogTitle;
    }

    public String getImageDialogTitle() {
        return imageDialogTitle;
    }

    public String getImageTitle() {
        return imageTitle;
    }
}
