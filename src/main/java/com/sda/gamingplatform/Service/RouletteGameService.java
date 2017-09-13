package com.sda.gamingplatform.Service;

import com.sda.gamingplatform.config.GameConfig;
import com.sda.gamingplatform.roulette.BoardCreator;
import com.sda.gamingplatform.roulette.Field;
import com.sda.gamingplatform.roulette.GameResponse;
import com.sda.gamingplatform.roulette.TypeOfBetsCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouletteGameService {

    private GameConfig gameConfig;
    private BoardCreator boardCreator = new BoardCreator();
    private TypeOfBetsCreator typeOfBetsCreator = new TypeOfBetsCreator();
    private List<Field> fields = boardCreator.createFields();
    private List<List<Field>> typesOfBets = typeOfBetsCreator.getTypesOfBets();

    @Autowired
    public RouletteGameService() {
        gameConfig = new GameConfig();
    }

    public GameResponse decodeGameConfig (){

        switch (gameConfig.getGameType()){
            case "StraightUp":

                break;
            case "StreetBet":

                break;
            case "ColumnBet":

                break;
            case "DozenBet":

                break;
            case "EvenOddBet":

                break;
            case "RedBlackBet":

                break;
        }



return null;
    }
}
