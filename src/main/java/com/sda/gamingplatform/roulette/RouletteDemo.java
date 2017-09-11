package com.sda.gamingplatform.roulette;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RouletteDemo {

    static BoardCreator boardCreator = new BoardCreator();
    static List<Field> fields = boardCreator.createFields();
    static Random random = new Random();

    public static void main(String[] args) {


        System.out.println(spinTheWheel());


    }

    static Field spinTheWheel() {

        Collections.shuffle(fields);
        return fields.get(random.nextInt(fields.size()));
    }


}
