package com.sda.gamingplatform.roulette;

public class Field {

    private String color;

    public Integer getValue() {
        return value;
    }

    private Integer value;

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
