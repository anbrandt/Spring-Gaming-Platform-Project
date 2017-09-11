package com.sda.gamingplatform.roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class BoardCreator {

    static List<Field> fields = new ArrayList<>();
    static List<List<Field>> typesOfBets = new ArrayList<>();

    public List<Field> createFields() {

        createBlackFields();
        createRedFields();
        fields.add(new Field(0));

        return fields;
    }

    public void createBlackFields() {

        int[] blacks = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};
        for (int i = 0; i < blacks.length; i++) {
            fields.add(new Field("Red", blacks[i]));
        }
    }

    public void createRedFields() {

        int[] reds = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
        for (int i = 0; i < reds.length; i++) {
            fields.add(new Field("Black", reds[i]));
        }
    }

    public List<List<Field>> createTypesOfBets(){

        List<Field> sortedAndStraightUp = straightUpBets();
        typesOfBets.add(sortedAndStraightUp);

        addStreetBets(sortedAndStraightUp);
        addColumnBets(sortedAndStraightUp);

        return typesOfBets;
    }

    public List<Field> straightUpBets() {

        return fields.stream()
                .sorted(Comparator.comparing(Field::getValue))
                .collect(Collectors.toList());
    }

    public void addStreetBets(List<Field> sorted){

        List<Field> from1to3   = Arrays.asList(sorted.get(1), sorted.get(2), sorted.get(3));
        List<Field> from4to6   = Arrays.asList(sorted.get(4), sorted.get(5), sorted.get(6));
        List<Field> from7to9   = Arrays.asList(sorted.get(7), sorted.get(8), sorted.get(9));
        List<Field> from10to12 = Arrays.asList(sorted.get(10), sorted.get(11), sorted.get(12));
        List<Field> from13to15 = Arrays.asList(sorted.get(13), sorted.get(14), sorted.get(15));
        List<Field> from16to18 = Arrays.asList(sorted.get(16), sorted.get(17), sorted.get(18));
        List<Field> from19to21 = Arrays.asList(sorted.get(19), sorted.get(20), sorted.get(21));
        List<Field> from22to24 = Arrays.asList(sorted.get(22), sorted.get(23), sorted.get(24));
        List<Field> from25to27 = Arrays.asList(sorted.get(25), sorted.get(26), sorted.get(27));
        List<Field> from28to30 = Arrays.asList(sorted.get(28), sorted.get(29), sorted.get(30));
        List<Field> from31to33 = Arrays.asList(sorted.get(31), sorted.get(32), sorted.get(33));
        List<Field> from34to36 = Arrays.asList(sorted.get(34), sorted.get(35), sorted.get(36));


        typesOfBets.add(from1to3);
        typesOfBets.add(from4to6);
        typesOfBets.add(from7to9);
        typesOfBets.add(from10to12);
        typesOfBets.add(from13to15);
        typesOfBets.add(from16to18);
        typesOfBets.add(from19to21);
        typesOfBets.add(from22to24);
        typesOfBets.add(from25to27);
        typesOfBets.add(from28to30);
        typesOfBets.add(from31to33);
        typesOfBets.add(from34to36);
    }

    public void addColumnBets(List<Field> sorted){

        //finish it
        List<Field> from1to34 = Arrays.asList(sorted.get(1), sorted.get(2), sorted.get(3));
        List<Field> from2to35 = Arrays.asList(sorted.get(4), sorted.get(5), sorted.get(6));
        List<Field> from3to36 = Arrays.asList(sorted.get(7), sorted.get(8), sorted.get(9));

        typesOfBets.add(from1to34);
        typesOfBets.add(from2to35);
        typesOfBets.add(from3to36);
    }
}