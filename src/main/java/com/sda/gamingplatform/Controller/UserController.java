package com.sda.gamingplatform.Controller;

import com.sda.gamingplatform.Entities.User;
import com.sda.gamingplatform.Service.UserService;
import com.sda.gamingplatform.config.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@Controller
public class UserController {

	private UserService userService;

	@Autowired
	public UserController (UserService userService) {
		this.userService = userService;
	}


	/*@RequestMapping(value = "/getusers", method = RequestMethod.GET)
	public ResponseEntity<Iterable<User>> getAllUsers() {
		Iterable<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<Iterable<User>>(allUsers, HttpStatus.OK);
	}*/

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerOk(@ModelAttribute User user, Model model) {

		userService.create(user);

		return "registerok";
	}


}
