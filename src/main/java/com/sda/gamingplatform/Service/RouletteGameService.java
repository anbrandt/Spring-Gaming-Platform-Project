package com.sda.gamingplatform.Service;

import com.sda.gamingplatform.config.GameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouletteGameService {

    private GameConfig gameConfig;

    @Autowired
    public RouletteGameService(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }
}
