package com.sda.gamingplatform.service;

import com.sda.gamingplatform.entities.User;
import com.sda.gamingplatform.entities.UserRole;
import com.sda.gamingplatform.repository.UserRepository;
import com.sda.gamingplatform.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

	private UserRepository userRepository;
	private UserRoleRepository userRoleRepository;

	@Autowired
	public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository) {
		this.userRepository = userRepository;
		this.userRoleRepository = userRoleRepository;
	}

	public String create(User user) {

		User newUser = userRepository.save(user);

		UserRole userRole = new UserRole();
		userRole.setRole("ROLE_USER");
		userRole.setUsername(user.getUsername());

		userRoleRepository.save(userRole);

		return newUser.getUsername();
	}
	public Iterable<User> getAllUsers() {
		Iterable<User> allUsers = userRepository.findAll();

		return allUsers;
	}


}
