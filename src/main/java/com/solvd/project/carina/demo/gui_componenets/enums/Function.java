package com.solvd.project.carina.demo.gui_componenets.enums;

public enum Function {

    OPEN("Open..."),
    SAVE("Save"),
    DELETE("Delete");

    private final String function;

    Function(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }
}
