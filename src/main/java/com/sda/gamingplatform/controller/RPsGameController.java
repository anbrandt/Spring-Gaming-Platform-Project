package com.sda.gamingplatform.controller;

import com.sda.gamingplatform.service.RouletteGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RPsGameController {

    private RouletteGameService rouletteGameService;

    @Autowired
    public RPsGameController (RouletteGameService rouletteGameService) {
        this.rouletteGameService = rouletteGameService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "game";
    }

    @RequestMapping(value = "/roulette", method = RequestMethod.GET)
	public String startRoulette() {
    	return "roulette";
	}

}
