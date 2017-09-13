package com.sda.gamingplatform.Service;

import com.sda.gamingplatform.config.GameConfig;
import com.sda.gamingplatform.roulette.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Random;

@Service
public class RouletteGameService {

    private BoardCreator boardCreator = new BoardCreator();
    private TypeOfBetsCreator typeOfBetsCreator = new TypeOfBetsCreator();
    private List<Field> fields = boardCreator.createFields();
    private List<List<Field>> typesOfBets = typeOfBetsCreator.getTypesOfBets();
    private FieldRandom fieldRandom;


    @Autowired
    public RouletteGameService(FieldRandom fieldRandom) {
        this.fieldRandom = fieldRandom;
    }

    public GameResponse decodeGameConfig(GameConfig gameConfig) {

        Field field = generateRandomField();
        BigInteger score = new BigInteger("0");

        if (field.getValue() == 0) {
            return new GameResponse(field, new BigInteger("0"));
        } else {

            switch (gameConfig.getGameType()) {
                case "StraightUp":
                    score = whenStraightUp(field, gameConfig);
                    break;
                case "StreetBet":
                    score = whenStreetBet(field, gameConfig);
                    break;
                case "ColumnBet":

                    break;
                case "DozenBet":

                    break;
                case "EvenOddBet":

                    break;
                case "RedBlackBet":

                    break;
            }
        }

        return new GameResponse(field, score);
    }

    public Field generateRandomField() {
        return fieldRandom.generateRandomField();
    }

    public BigInteger whenStraightUp(Field drawnField, GameConfig gameConfig) {

        BigInteger multiplier = new BigInteger("35");

        String[] playerChoice = gameConfig.getChosenField().split(" ");
        Field playerField = new Field(playerChoice[0], Integer.parseInt(playerChoice[1]));

        if (drawnField.equals(playerField)) {
            return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
        }

        return new BigInteger("0");
    }

    public BigInteger whenStreetBet(Field drawnField, GameConfig gameConfig) {

        BigInteger multiplier = new BigInteger("11");

        int playerChoice = Integer.parseInt(gameConfig.getChosenField());

        switch (playerChoice){
            case 1:
                if (typesOfBets.get(1).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 2:
                if (typesOfBets.get(2).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 3:
                if (typesOfBets.get(3).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 4:
                if (typesOfBets.get(4).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 5:
                if (typesOfBets.get(5).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 6:
                if (typesOfBets.get(6).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 7:
                if (typesOfBets.get(7).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 8:
                if (typesOfBets.get(8).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 9:
                if (typesOfBets.get(9).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 10:
                if (typesOfBets.get(10).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 11:
                if (typesOfBets.get(11).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
            case 12:
                if (typesOfBets.get(12).contains(drawnField))
                    return new BigInteger(String.valueOf((gameConfig.getChips().multiply(multiplier)).add(gameConfig.getChips())));
                break;
        }

        return new BigInteger("0");
    }


}
