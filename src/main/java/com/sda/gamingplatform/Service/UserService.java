package com.sda.gamingplatform.Service;

import com.sda.gamingplatform.Entities.User;
import com.sda.gamingplatform.Entities.UserRole;
import com.sda.gamingplatform.Repository.UserRepository;
import com.sda.gamingplatform.Repository.UserRoleRepository;
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
