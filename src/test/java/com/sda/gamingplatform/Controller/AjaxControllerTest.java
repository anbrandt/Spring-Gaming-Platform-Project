package com.sda.gamingplatform.Controller;

import com.sda.gamingplatform.Service.RouletteGameService;
import com.sda.gamingplatform.config.GameConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;

import static org.junit.Assert.*;

//TODO use mockmvc in later functions
public class AjaxControllerTest {

	private MockMvc mockMvc;
	private RouletteGameService rouletteGameService;

	@Before
	public void setUp() {
//		rouletteGameService = new RouletteGameService();
	}

	@Test
	public void getFromJson_shouldReturnString() throws Exception {
		BigInteger bigInteger = BigInteger.valueOf(33);
		GameConfig config = new GameConfig("color", "red", bigInteger);

		Assert.assertEquals("red", config.getChosenField());

	}

}