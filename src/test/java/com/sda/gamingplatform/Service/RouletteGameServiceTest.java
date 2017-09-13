package com.sda.gamingplatform.Service;

import com.sda.gamingplatform.config.GameConfig;
import com.sda.gamingplatform.roulette.Field;
import com.sda.gamingplatform.roulette.FieldRandom;
import com.sda.gamingplatform.roulette.GameResponse;
import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",1));

        gameConfig = new GameConfig("StraightUp", "Red 1", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("360");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void straightUpShouldReturn0IfNotEquals() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",1));

        gameConfig = new GameConfig("StraightUp", "Black 2", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);
      
        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldReturn110WhenWinStreetBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",1));

        gameConfig = new GameConfig("StreetBet", "1", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("120");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldReturn0WhenLooseStreetBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",1));

        gameConfig = new GameConfig("StreetBet", "2", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldReturn30WhenWinColumnBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",1));

        gameConfig = new GameConfig("ColumnBet", "1", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("30");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0WhenLooseColumnBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",1));

        gameConfig = new GameConfig("ColumnBet", "2", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn30WhenWinDozenBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",27));

        gameConfig = new GameConfig("DozenBet", "3", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("30");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0WhenLooseDozenBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",3));

        gameConfig = new GameConfig("DozenBet", "2", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn20WhenWinEvenOddBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",27));

        gameConfig = new GameConfig("EvenOddBet", "2", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("20");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0WhenLooseEvenOddBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Black",2));

        gameConfig = new GameConfig("EvenOddBet", "2", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn20WhenWin18sBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",27));

        gameConfig = new GameConfig("18sBet", "2", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("20");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0WhenLoose18sBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Black",2));

        gameConfig = new GameConfig("18sBet", "2", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn20WhenWinRedBlackBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red",27));

        gameConfig = new GameConfig("RedBlackBet", "1", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("20");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0WhenLooseRedBlackBet() throws Exception {

        FieldRandom fieldRandom = Mockito.mock(FieldRandom.class);
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Black",2));

        gameConfig = new GameConfig("RedBlackBet", "1", new BigInteger("10"));
        gameService = new RouletteGameService(fieldRandom);

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decodeGameConfig() throws Exception {


    }
}