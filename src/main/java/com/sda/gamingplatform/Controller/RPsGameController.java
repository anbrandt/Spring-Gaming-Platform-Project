package com.sda.gamingplatform.Controller;

import com.sda.gamingplatform.Service.RouletteGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPsGameController {

    private RouletteGameService rouletteGameService;

    @Autowired
    public RPsGameController (RouletteGameService rouletteGameService) {
        this.rouletteGameService = rouletteGameService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Kornel and The Holocausts";
    }

}
