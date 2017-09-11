package com.sda.gamingplatform.roulette;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BoardCreatorTest {

    BoardCreator boardCreator;
    List<Field> fields;

    @Before
    public void setUp() {
        boardCreator = new BoardCreator();
        fields = boardCreator.createFields();
    }

    @Test
    public void shouldCreate37Fields() {

        int expected = 37;
        int actual = fields.size();

        Assert.assertEquals(expected, actual);

    }
}