package com.sda.gamingplatform.Controller;

import com.sda.gamingplatform.Entities.User;
import com.sda.gamingplatform.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by andrzej on 07.09.17.
 */

@RestController
public class UserController {

	private UserService userService;

	@Autowired
	public UserController (UserService userService) {
		this.userService = userService;
	}


	@RequestMapping (value = "/login")
	public String loginUser() {
		return "login";
	}

	@RequestMapping (value = "/register", method = RequestMethod.GET)
	public String registerUser() {
		return "register";
	}

	@RequestMapping (value = "/register", method = RequestMethod.POST)
	public void registerUserPost(@ModelAttribute User user, Model model) {

		userService.create(user);

	}

}
