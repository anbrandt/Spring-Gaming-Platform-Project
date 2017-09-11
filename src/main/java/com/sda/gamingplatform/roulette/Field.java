package com.sda.gamingplatform.roulette;

public class Field {

    private String color;
    private Integer value;

    public String getColor() {
        return color;
    }

    public Integer getValue() {
        return value;
    }

    public Field(String color, Integer value) {
        this.color = color;
        this.value = value;
    }

    public Field(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return color == null ? String.valueOf(value) : color + " " + value;
    }
}
