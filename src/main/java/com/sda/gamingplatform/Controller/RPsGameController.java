package com.sda.gamingplatform.Controller;

import com.sda.gamingplatform.Service.RPsGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPsGameController {

    private RPsGameService rPsGameService;

    @Autowired
    public RPsGameController (RPsGameService rPsGameService) {
        this.rPsGameService = rPsGameService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Kornel and The Holocausts";
    }

}
