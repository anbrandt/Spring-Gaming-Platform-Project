package com.sda.gamingplatform.Repository;

import com.sda.gamingplatform.Entities.User;
import com.sda.gamingplatform.Entities.UserRole;
import org.springframework.data.repository.CrudRepository;

//TODO handling adding users automatically to users_role table with ROLE_USER
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {



}
