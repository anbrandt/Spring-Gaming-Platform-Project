package com.sda.gamingplatform.Controller;


import com.sda.gamingplatform.config.GameConfig;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AjaxController {

/*
	@RequestMapping(value = "/roulette", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> getJsonFromRoulette(@RequestBody String jsonString){
		System.out.println("received :" + jsonString);
		*/
/*try {
			customerService.saveCustomer(customer);
			return new Status(code, message);
		} catch (Exception e) {
			return new Status(0, e.toString());
		}*//*

		return new ResponseEntity<String>(jsonString, HttpStatus.OK);
	}
*/


	@RequestMapping(value = "/roulette", method = RequestMethod.POST)
	public String getFromJson(@RequestBody GameConfig gameConfig){

		String chosenField = gameConfig.getChosenField();
		System.out.println(gameConfig.getGameType() + gameConfig.getChosenField() + gameConfig.getChips());
		return chosenField;
	}

}
