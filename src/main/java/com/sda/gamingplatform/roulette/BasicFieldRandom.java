package com.sda.gamingplatform.roulette;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

/**
 * Created by RENT on 2017-09-13.
 */

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
