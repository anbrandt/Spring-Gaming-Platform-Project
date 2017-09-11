package com.sda.gamingplatform.roulette;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BoardCreatorTest {

    BoardCreator boardCreator;
    List<Field> fields;
    List<List<Field>> typesOfBets;

    @Before
    public void setUp() {
        boardCreator = new BoardCreator();
        fields = boardCreator.createFields();
        typesOfBets = new ArrayList<>();
    }

    @Test
    public void shouldCreate37Fields() {

        int expected = 37;
        int actual = fields.size();

        Assert.assertEquals(expected, actual);

    }

//    @Test
//    public void shouldCreateSortedStraightUpList(){
//        List<Field> straightUp = boardCreator.straightUpBets();
//        straightUp.forEach(System.out::println);
//    }

//    @Test
//    public void shouldReturnStreetLists(){
//
//        List<Field> sortedAndStraightUp = boardCreator.straightUpBets();
//        boardCreator.addStreetBets(sortedAndStraightUp);
//        typesOfBets.forEach(list -> System.out.println(list.toString()));
//    }
}