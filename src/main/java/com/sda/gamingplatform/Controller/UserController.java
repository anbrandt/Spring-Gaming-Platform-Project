package com.sda.gamingplatform.Controller;

import com.sda.gamingplatform.Entities.User;
import com.sda.gamingplatform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping(value = "/useradd", method = RequestMethod.POST)
	public ResponseEntity<Long> createUser(@RequestBody User user) {
		Long aLong = userService.create(user);
		return new ResponseEntity<>(aLong, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/getusers", method = RequestMethod.GET)
	public ResponseEntity<Iterable<User>> getAllUsers() {
		Iterable<User> allUsers = userService.getAllUsers();
		return new ResponseEntity<Iterable<User>>(allUsers, HttpStatus.OK);
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
