package com.sda.gamingplatform.Service;

import com.sda.gamingplatform.config.GameConfig;
import com.sda.gamingplatform.roulette.Field;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

public class RouletteGameServiceTest {

    RouletteGameService gameService;
    GameConfig gameConfig;

    @Before
    public void setUp(){
    }

    @Test
    public void straightUpShouldReturn360IfEquals() throws Exception {

        gameConfig = new GameConfig("StraightUp", "Black 2", new BigInteger("10"));
        gameService = new RouletteGameService(gameConfig);

        BigInteger expected = new BigInteger("360");
        BigInteger actual = gameService.whenStraightUp(new Field("Black", 2));

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void straightUpShouldReturn0IfNotEquals() throws Exception {

        gameConfig = new GameConfig("StraightUp", "Black 2", new BigInteger("10"));
        gameService = new RouletteGameService(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameService.whenStraightUp(new Field("Red", 1));

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldReturn110WhenWinStreetBet() throws Exception {

        gameConfig = new GameConfig("StreetBet", "1", new BigInteger("10"));
        gameService = new RouletteGameService(gameConfig);

        BigInteger expected = new BigInteger("120");
        BigInteger actual = gameService.whenStreetBet(new Field("Red", 1));

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldReturn0WhenLooseStreetBet() throws Exception {

        gameConfig = new GameConfig("StreetBet", "2", new BigInteger("10"));
        gameService = new RouletteGameService(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameService.whenStreetBet(new Field("Red", 1));

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void decodeGameConfig() throws Exception {


    }
}