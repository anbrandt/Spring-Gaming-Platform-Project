package com.sda.gamingplatform.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrzej on 07.09.17.
 */

@RestController
public class UserController {


	@RequestMapping (value = "/login")
	public String loginUser() {
		return "hello";
	}

	@RequestMapping (value = "/register", method = RequestMethod.GET)
	public String registerUser() {
		return "register";
	}

}
