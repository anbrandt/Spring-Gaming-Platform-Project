package com.sda.gamingplatform.roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class BoardCreator {

    public List<Field> createFields() {

        List<Field> fields = new ArrayList<>();

        createBlackFields(fields);
        createRedFields(fields);
        fields.add(new Field(0));

        return fields;
    }

    public void createBlackFields(List<Field> fields) {

        int[] blacks = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        for (int i = 0; i < blacks.length; i++) {
            fields.add(new Field("Black", blacks[i]));
        }
    }

    public void createRedFields(List<Field> fields) {

        int[] reds = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        for (int i = 0; i < reds.length; i++) {
            fields.add(new Field("Red", reds[i]));
        }
    }
}