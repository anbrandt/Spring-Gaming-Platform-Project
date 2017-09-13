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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameResponse that = (GameResponse) o;

        if (winningField != null ? !winningField.equals(that.winningField) : that.winningField != null) return false;
        return score != null ? score.equals(that.score) : that.score == null;
    }

    @Override
    public int hashCode() {
        int result = winningField != null ? winningField.hashCode() : 0;
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
