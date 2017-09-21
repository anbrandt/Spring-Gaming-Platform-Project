package com.sda.gamingplatform.repository;

import com.sda.gamingplatform.entities.UserRole;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Integer> {


    @Query("SELECT ur FROM user_roles ur WHERE ur.role <> 'ROLE_ADMIN'")
    Iterable<UserRole> findAllNonAdmin();

}
