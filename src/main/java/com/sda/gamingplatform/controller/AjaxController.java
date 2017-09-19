package com.sda.gamingplatform.controller;


import com.sda.gamingplatform.entities.Chips;
import com.sda.gamingplatform.roulette.GameResult;
import com.sda.gamingplatform.service.ChipService;
import com.sda.gamingplatform.service.RouletteGameService;
import com.sda.gamingplatform.config.GameConfig;
import com.sda.gamingplatform.roulette.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class AjaxController {

	private RouletteGameService rouletteGameService;
	private ChipService chipService;

	@Autowired
	public AjaxController(RouletteGameService rouletteGameService, ChipService chipService) {
		this.rouletteGameService = rouletteGameService;
		this.chipService = chipService;
	}



	@RequestMapping(value = "/roulette", method = RequestMethod.POST)
	public GameResult getFromJson(@RequestBody GameConfig gameConfig){

		String chosenField = gameConfig.getChosenField();
		System.out.println(gameConfig.getGameType() + gameConfig.getChosenField() + gameConfig.getChips());

		GameResponse gameResponse = rouletteGameService.decodeGameConfig(gameConfig);
		System.out.println("Score :" + gameResponse.getScore() + "\n " + " Winning field : " + gameResponse.getWinningField());
		BigInteger bigInteger = chipService.updatedAmount(gameResponse);

		GameResult gameResult = new GameResult(gameResponse.getWinningField().toString(), bigInteger);
		System.out.println(gameResult.getChips() + " chips \n" + gameResult.getDrawnField());
		return gameResult;
	}

}
