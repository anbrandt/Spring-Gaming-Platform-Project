package com.sda.gamingplatform;

import com.sda.gamingplatform.Entities.User;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Created by andrzej on 07.09.17.
 */

@Service
public class UserService {


	public void create(User user) {
		if(!Objects.equals(user.getPassword(), user.getConfirmPassword()));
//			return "Passwords dont'match!";


	}
}
