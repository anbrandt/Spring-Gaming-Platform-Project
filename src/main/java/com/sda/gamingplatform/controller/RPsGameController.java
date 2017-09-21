package com.sda.gamingplatform.controller;

import com.sda.gamingplatform.service.ChipService;
import com.sda.gamingplatform.service.RouletteGameService;
import com.sda.gamingplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RPsGameController {

    private RouletteGameService rouletteGameService;
    private ChipService chipService;
    private UserService userService;

    @Autowired
    public RPsGameController(RouletteGameService rouletteGameService, ChipService chipService, UserService userService) {
        this.rouletteGameService = rouletteGameService;
        this.chipService = chipService;
        this.userService = userService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "game";
    }

    @RequestMapping(value = "/roulette", method = RequestMethod.GET)
    public String startRoulette(Model model) {
        model.addAttribute("chipsAmount", chipService.getChipsAmount());
        System.out.println(chipService.getChipsAmount());
        return "roulette";
    }

    @RequestMapping("/adminmanager")
    public String users(Model model) {
        model.addAttribute("users", userService.getAllUserRoles());
        return "adminmanager";
    }

    @RequestMapping("/adminmanager/{id}")
    public String admin(@PathVariable("id") long id, Model model) {

      //  new UserRole(id,"ROLE_ADMIN")
        //TODO: set admin rights

        return users(model);
    }
}
