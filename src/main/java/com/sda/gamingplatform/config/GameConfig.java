package com.sda.gamingplatform.config;

import java.math.BigInteger;

public class GameConfig {

	private String gameType;
	private String chosenField;
	private BigInteger chips;

	public GameConfig() {}

	public GameConfig(String gameType, String chosenField, BigInteger chips) {
		this.gameType = gameType;
		this.chosenField = chosenField;
		this.chips = chips;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public String getChosenField() {
		return chosenField;
	}

	public void setChosenField(String chosenField) {
		this.chosenField = chosenField;
	}

	public BigInteger getChips() {
		return chips;
	}

	public void setChips(BigInteger chips) {
		this.chips = chips;
	}
}
