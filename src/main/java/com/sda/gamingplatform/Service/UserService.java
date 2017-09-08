package com.sda.gamingplatform.Service;

import com.sda.gamingplatform.Entities.User;
import com.sda.gamingplatform.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	public Long create(User user) {
		User createdUser = userRepository.save(user);
		return createdUser.getId();
	}

	public Iterable<User> getAllUsers() {
		Iterable<User> allUsers = userRepository.findAll();
		List<User> allUsersList = new ArrayList<>();

		for (User allUser : allUsers) {
			allUsersList.add(allUser);
		}
		return allUsersList;

	}

}
