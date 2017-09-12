package com.sda.gamingplatform.roulette;

import java.math.BigInteger;

public class GameResponse {

    private Field winningField;
    private BigInteger score;

    public Field getWinningField() {
        return winningField;
    }

    public void setWinningField(Field winningField) {
        this.winningField = winningField;
    }

    public BigInteger getScore() {
        return score;
    }

    public void setScore(BigInteger score) {
        this.score = score;
    }

    public GameResponse(Field winningField, BigInteger score) {
        this.winningField = winningField;
        this.score = score;
    }
}
