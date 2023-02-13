package com.solvd.project.carina.demo.gui_componenets.enums;

public enum MenuOptions {

    RANDOM_PROGRESS_BAR("Random Progress Bar"),
    COLOR_PICKER("Color Picker"),
    RANGE("Range"),
    IMAGE_BASED("Image Based"),
    VIDEO_BASED("Video Based"),
    RESIZE_ACCORDION("Re-Size Accordion"),
    COMBO_BOX("ComboBox"),
    SIMPLE_SPINNER("Simple Spinner"),
    DROP_DOWN_DATA_PICKER("DropDown DatePicker"),
    MULTIPLE_LIST("Multiple Lists");

    private final String menuName;

    MenuOptions(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }
}
