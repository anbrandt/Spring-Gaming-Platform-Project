package com.sda.gamingplatform.roulette;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.*;

public class RouletteDemo {

    static Scanner scanner = new Scanner(System.in);
    static BoardCreator boardCreator = new BoardCreator();
    static TypeOfBetsCreator typeCreator = new TypeOfBetsCreator();
    static List<Field> fields = boardCreator.createFields();
    static List<List<Field>> typeOfBets = typeCreator.createTypesOfBets(fields);
    static Random random = new Random();

    public static void main(String[] args) {

        typeOfBets.forEach(list -> System.out.println(list.toString()));
    }

    static void typeChoice() {

        int choice = 0;
        int validationIndex;

        System.out.println("Choose type of bet: ");

        try {
            int input = scanner.nextInt();
            choice = input;
        } catch (InputMismatchException e) {
            System.out.println("invalid choice!");
        }


        switch (choice) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            default:
                System.out.println("crap");
                break;
        }
    }

    static Field spinTheWheel() {

        Collections.shuffle(fields);
        return fields.get(random.nextInt(fields.size()));
    }
}
