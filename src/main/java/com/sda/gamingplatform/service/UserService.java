package com.sda.gamingplatform.service;

import com.sda.gamingplatform.dto.UserDto;
import com.sda.gamingplatform.entities.Chips;
import com.sda.gamingplatform.entities.User;
import com.sda.gamingplatform.entities.UserRole;
import com.sda.gamingplatform.repository.ChipsRepository;
import com.sda.gamingplatform.repository.UserRepository;
import com.sda.gamingplatform.repository.UserRoleRepository;
import com.sda.gamingplatform.transform.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;
    private UserRoleRepository userRoleRepository;
    private ChipsRepository chipsRepository;
    private UserTransformer userTransformer;

    @Autowired
    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, ChipsRepository chipsRepository, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.chipsRepository = chipsRepository;
        this.userTransformer = userTransformer;
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

    public Iterable<UserRole> getAllUserRoles() {
        Iterable<UserRole> allUserRoles = userRoleRepository.findAll();

        return allUserRoles;
    }

    public Iterable<UserDto> getAllNonAdmin() {
        Iterable<UserRole> allNonAdmin = userRoleRepository.findAllNonAdmin();
        List<UserDto> users = new ArrayList<>();
        for (UserRole userRole : allNonAdmin) {
            users.add(userTransformer.transformFromUserRole(userRole));
        }
        return users;
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public void grantAdminRole(Integer id) {
        UserRole userRole = userRoleRepository.findOne(id);
        userRole.setRole("ROLE_ADMIN");
        userRoleRepository.save(userRole);
    }
}
