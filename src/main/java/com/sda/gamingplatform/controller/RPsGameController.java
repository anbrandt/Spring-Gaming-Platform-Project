package com.sda.gamingplatform.controller;

import com.sda.gamingplatform.service.ChipService;
import com.sda.gamingplatform.service.RouletteGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RPsGameController {

    private RouletteGameService rouletteGameService;
    private ChipService chipService;

    @Autowired
    public RPsGameController (RouletteGameService rouletteGameService, ChipService chipService) {
        this.rouletteGameService = rouletteGameService;
    	this.chipService = chipService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "game";
    }

    @RequestMapping(value = "/roulette", method = RequestMethod.GET)
	public String startRoulette(Model model) {
    	model.addAttribute("chipsAmount", chipService.getChipsAmount());
		System.out.println(chipService.getChipsAmount());
		return "roulette";
	}

    @RequestMapping("/adminmanager")
    public String users() {
        return "adminmanager";
    }
}
