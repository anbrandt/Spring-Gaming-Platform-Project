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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Field field = (Field) o;

        if (!color.equals(field.color)) return false;
        return value.equals(field.value);
    }

    @Override
    public int hashCode() {
        int result = color.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
