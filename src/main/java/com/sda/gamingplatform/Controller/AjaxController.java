package com.sda.gamingplatform.Controller;


import com.sda.gamingplatform.Service.RouletteGameService;
import com.sda.gamingplatform.config.GameConfig;
import com.sda.gamingplatform.roulette.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

	private RouletteGameService rouletteGameService;

	@Autowired
	public AjaxController(RouletteGameService rouletteGameService) {
		this.rouletteGameService = rouletteGameService;
	}



	@RequestMapping(value = "/roulette", method = RequestMethod.POST)
	public GameResponse getFromJson(@RequestBody GameConfig gameConfig){

		String chosenField = gameConfig.getChosenField();
		System.out.println(gameConfig.getGameType() + gameConfig.getChosenField() + gameConfig.getChips());

		GameResponse gameResponse = rouletteGameService.decodeGameConfig(gameConfig);
//		System.out.println(gameResponse.getScore() + " " + gameResponse.getWinningField());

		return gameResponse;
	}

}
