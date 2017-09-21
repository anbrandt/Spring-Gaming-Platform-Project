package com.sda.gamingplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String getIndex() {
	return "index2";
}

@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getRightIndex() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}

	@RequestMapping(value = "/gameroom", method = RequestMethod.GET)
	public String getGameRoom() {
		return "gameroom";
	}
}
