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

}
