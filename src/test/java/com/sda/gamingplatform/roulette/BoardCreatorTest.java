package com.sda.gamingplatform.roulette;

import com.sda.gamingplatform.Service.RouletteGameService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BoardCreatorTest {

    BoardCreator boardCreator;
    TypeOfBetsCreator typesCreator;
    List<Field> fields;
    List<List<Field>> typesOfBets;

    @Before
    public void setUp() {
        boardCreator = new BoardCreator();
        typesCreator = new TypeOfBetsCreator();
        fields = boardCreator.createFields();
        typesOfBets = new ArrayList<>();
    }

    @Test
    public void shouldCreate37Fields() {

        int expected = 37;
        int actual = fields.size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldReturnAllTypesOfBets(){

        List<List<Field>> types = typesCreator.createTypesOfBets(boardCreator.createFields());
        typesOfBets.forEach(list -> System.out.println(list.toString()));
    }

}