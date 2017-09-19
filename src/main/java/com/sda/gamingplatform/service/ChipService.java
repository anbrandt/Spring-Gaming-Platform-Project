package com.sda.gamingplatform.service;


import com.sda.gamingplatform.entities.Chips;
import com.sda.gamingplatform.entities.User;
import com.sda.gamingplatform.repository.ChipsRepository;
import com.sda.gamingplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ChipService {

	private ChipsRepository chipsRepository;
	private UserRepository userRepository;

	@Autowired
	public ChipService(ChipsRepository chipsRepository, UserRepository userRepository) {
		this.chipsRepository = chipsRepository;
		this.userRepository = userRepository;
	}

	public BigInteger getChipsAmount() {
		String username = UserUtils.getUsername();
		User byUsername = userRepository.findByUsername(username);

		Chips one = chipsRepository.findOne(byUsername.getId());
		return one.getUser_chips();
	}

	public BigInteger updatedAmount() {



		return null;
	}


}
