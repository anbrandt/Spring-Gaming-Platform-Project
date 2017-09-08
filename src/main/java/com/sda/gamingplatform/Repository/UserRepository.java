package com.sda.gamingplatform.Repository;

import com.sda.gamingplatform.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
