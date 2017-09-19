package com.sda.gamingplatform.repository;

import com.sda.gamingplatform.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
