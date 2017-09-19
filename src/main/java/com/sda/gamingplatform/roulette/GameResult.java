package com.sda.gamingplatform.roulette;


import java.math.BigInteger;

public class GameResult {

	private String drawnField;
	private BigInteger chips;

	public GameResult() {
	}

	public GameResult(String drawnField, BigInteger chips) {
		this.drawnField = drawnField;
		this.chips = chips;
	}

	public String getDrawnField() {
		return drawnField;
	}

	public void setDrawnField(String drawnField) {
		this.drawnField = drawnField;
	}

	public BigInteger getChips() {
		return chips;
	}

	public void setChips(BigInteger chips) {
		this.chips = chips;
	}
}
