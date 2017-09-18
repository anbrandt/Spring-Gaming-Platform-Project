package com.sda.gamingplatform.service;

import com.sda.gamingplatform.entities.Spin;
import com.sda.gamingplatform.repository.SpinRepository;
import com.sda.gamingplatform.config.GameConfig;
import com.sda.gamingplatform.roulette.Field;
import com.sda.gamingplatform.roulette.FieldRandom;
import com.sda.gamingplatform.roulette.GameResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.math.BigInteger;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.any;
import static org.mockito.MockitoAnnotations.initMocks;

public class RouletteGameServiceTest {

    private RouletteGameService gameService;
    private GameConfig gameConfig;
    @Mock
    private FieldRandom fieldRandom;
    @Mock
    private SpinRepository spinRepository;

    @Before
    public void setUp() {
        initMocks(this);
        gameService = new RouletteGameService(fieldRandom, spinRepository);
    }

    @Test
    public void straightUpShouldReturn360IfEquals() throws Exception {

        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 1));

        gameConfig = new GameConfig("StraightUp", "Red 1", new BigInteger("10"));

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("360");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void straightUpShouldReturn0IfNotEquals() throws Exception {

        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 1));

        gameConfig = new GameConfig("StraightUp", "Black 2", new BigInteger("10"));

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldReturn110WhenWinStreetBet() throws Exception {

        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 1));

        gameConfig = new GameConfig("StreetBet", "1", new BigInteger("10"));

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("120");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldReturn0WhenLooseStreetBet() throws Exception {

        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 1));

        gameConfig = new GameConfig("StreetBet", "2", new BigInteger("10"));

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void shouldReturn30WhenWinColumnBet() throws Exception {

        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 1));

        gameConfig = new GameConfig("ColumnBet", "1", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("30");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0WhenLooseColumnBet() throws Exception {

        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 1));

        gameConfig = new GameConfig("ColumnBet", "2", new BigInteger("10"));

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn30WhenWinDozenBet() throws Exception {

        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 27));

        gameConfig = new GameConfig("DozenBet", "3", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("30");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0WhenLooseDozenBet() throws Exception {

        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 3));

        gameConfig = new GameConfig("DozenBet", "2", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn20WhenWinEvenOddBet() throws Exception {

        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 27));

        gameConfig = new GameConfig("EvenOddBet", "2", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("20");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0WhenLooseEvenOddBet() throws Exception {
        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Black", 2));

        gameConfig = new GameConfig("EvenOddBet", "2", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn20WhenWin18sBet() throws Exception {

        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 27));

        gameConfig = new GameConfig("18sBet", "2", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("20");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0WhenLoose18sBet() throws Exception {

        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Black", 2));

        gameConfig = new GameConfig("18sBet", "2", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn20WhenWinRedBlackBet() throws Exception {

        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Red", 27));

        gameConfig = new GameConfig("RedBlackBet", "1", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("20");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0WhenLooseRedBlackBet() throws Exception {

        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Black", 2));

        gameConfig = new GameConfig("RedBlackBet", "1", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinIfChooseZeroInStraightUpBet() {
        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field(0));

        gameConfig = new GameConfig("StraightUp", "0", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("360");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldLooseIfDrawnZero() {
        
        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field(0));

        gameConfig = new GameConfig("DozenBet", "2", new BigInteger("10"));
        

        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldSaveSpinRecord(){


        Mockito.when(fieldRandom.generateRandomField()).thenReturn(new Field("Black",2));
        Spin spin = new Spin("anonymous","DozenBet 2 10","0","Black 2");

        Mockito.when(spinRepository.save(spin)).thenReturn(spin);

        gameConfig = new GameConfig("DozenBet", "2", new BigInteger("10"));


        GameResponse gameResponse = gameService.decodeGameConfig(gameConfig);

        BigInteger expected = new BigInteger("0");
        BigInteger actual = gameResponse.getScore();

        Assert.assertEquals(expected, actual);
        Mockito.verify(spinRepository,Mockito.times(1)).save(spin);

    }

    @Test
    public void decodeGameConfig() throws Exception {


    }
}