package com.sda.gamingplatform.roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TypeOfBetsCreator {

    static List<List<Field>> typesOfBets = new ArrayList<>();
    static List<Field> fields;

    public List<List<Field>> createTypesOfBets(List<Field> list) {

        fields = list;
        List<Field> sortedAndStraightUp = straightUpBets();
        typesOfBets.add(sortedAndStraightUp);

        /*zapytac czy moze zrobic oddzielna klase implementejuca arrayliste gdzie kazdej z list
        mozna bedzie nadac indentyfikujace imie?*/

        addStreetBets(sortedAndStraightUp);
        addColumnBets(sortedAndStraightUp);
        addDozenBets(sortedAndStraightUp);
        addEvenOddBets(sortedAndStraightUp);
        add18sBets(sortedAndStraightUp);
        addRedBlackBets(sortedAndStraightUp);

        return typesOfBets;
    }

    public List<Field> straightUpBets() {

        return fields.stream()
                .sorted(Comparator.comparing(Field::getValue))
                .collect(Collectors.toList());
    }

    public void addStreetBets(List<Field> sorted) {

        List<Field> from1to3 = Arrays.asList(sorted.get(1), sorted.get(2), sorted.get(3));
        List<Field> from4to6 = Arrays.asList(sorted.get(4), sorted.get(5), sorted.get(6));
        List<Field> from7to9 = Arrays.asList(sorted.get(7), sorted.get(8), sorted.get(9));
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

    public void addColumnBets(List<Field> sorted) {

        List<Field> from1to34 = new ArrayList<>();
        List<Field> from2to35 = new ArrayList<>();
        List<Field> from3to36 = new ArrayList<>();

        for (int i = 0; i < 34; i += 3) {
            for (int j = 1; j <= 3; j++) {
                if (j == 1) {
                    from1to34.add(sorted.get(i + j));
                } else if (j == 2) {
                    from2to35.add(sorted.get(i + j));
                } else {
                    from3to36.add(sorted.get(i + j));
                }
            }
        }

        typesOfBets.add(from1to34);
        typesOfBets.add(from2to35);
        typesOfBets.add(from3to36);
    }

    public void addDozenBets(List<Field> sorted){

        List<Field> from1to12 = new ArrayList<>();
        List<Field> from13to24 = new ArrayList<>();
        List<Field> from25to36 = new ArrayList<>();

        for (int i = 1; i <= 36; i++) {
            if (i <= 12){
                from1to12.add(sorted.get(i));
            } else if (i > 12 && i <= 24){
                from13to24.add(sorted.get(i));
            } else {
                from25to36.add(sorted.get(i));
            }
        }

        typesOfBets.add(from1to12);
        typesOfBets.add(from13to24);
        typesOfBets.add(from25to36);
    }

    public void addEvenOddBets(List<Field> sorted){

        List<Field> even = new ArrayList<>();
        List<Field> odd = new ArrayList<>();

        for (int i = 1; i <= 36; i++) {
            if (i == 1)
                odd.add(sorted.get(i));
            else if (i % 2 == 0)
                even.add(sorted.get(i));
            else
                odd.add(sorted.get(i));

        }

        typesOfBets.add(even);
        typesOfBets.add(odd);
    }

    public void add18sBets(List<Field> sorted){

        List<Field> from1to18 = new ArrayList<>();
        List<Field> from19to36 = new ArrayList<>();

        for (int i = 1; i <= 36; i++) {
            if (i <= 18){
                from1to18.add(sorted.get(i));
            } else {
                from19to36.add(sorted.get(i));
            }
        }

        typesOfBets.add(from1to18);
        typesOfBets.add(from19to36);
    }

    public void addRedBlackBets(List<Field> sorted){

        List<Field> reds = new ArrayList<>();
        List<Field> blacks = new ArrayList<>();

        for (int i = 1; i <= 36; i++) {
            if (sorted.get(i).getColor() == "Red")
                reds.add(sorted.get(i));
            else
                blacks.add(sorted.get(i));
        }

        typesOfBets.add(reds);
        typesOfBets.add(blacks);
    }
}
