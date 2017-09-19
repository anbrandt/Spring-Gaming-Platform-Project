package com.sda.gamingplatform.service;

import com.sda.gamingplatform.entities.Chips;
import com.sda.gamingplatform.entities.User;
import com.sda.gamingplatform.entities.UserRole;
import com.sda.gamingplatform.repository.ChipsRepository;
import com.sda.gamingplatform.repository.UserRepository;
import com.sda.gamingplatform.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;


@Service
public class UserService {

	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;
	private ChipsRepository chipsRepository;

	@Autowired
	public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, ChipsRepository chipsRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
		this.chipsRepository = chipsRepository;
	}

	public String create(User user) {

		User newUser = userRepository.save(user);

		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_USER");
		userRole.setUsername(user.getUsername());

		userRoleRepository.save(userRole);
		Chips chip = new Chips(user.getId(), new BigInteger("1000"));
		chipsRepository.save(chip);

		return newUser.getUsername();

	}
	public Iterable<User> getAllUsers() {
		Iterable<User> allUsers = userRepository.findAll();

		return allUsers;
	}

	public User getUserByUserName(String userName) {
		return userRepository.findByUsername(userName);
	}


}
