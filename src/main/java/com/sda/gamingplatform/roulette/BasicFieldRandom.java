package com.sda.gamingplatform.roulette;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class BasicFieldRandom implements FieldRandom {

    private List<Field> fields;

    public BasicFieldRandom() {
        fields = new BoardCreator().createFields();
    }

    @Override
    public Field generateRandomField() {
        Random random = new Random();
        return fields.get(random.nextInt(38));
    }
}
