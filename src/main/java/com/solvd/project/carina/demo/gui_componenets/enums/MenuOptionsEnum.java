package com.solvd.project.carina.demo.gui_componenets.enums;

public enum MenuOptionsEnum {
    RANDOM_PROGRESS_BAR("Random Progress Bar"), COLOR_PICKER("Color Picker"),
    RANGE("Range"), IMAGE_BASED("Image Based"),
    VIDEO_BASED("Video Based");

    private final String menuName;

    MenuOptionsEnum(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }


}
