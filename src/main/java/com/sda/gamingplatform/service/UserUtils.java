package com.sda.gamingplatform.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

/**
 * Created by RENT on 2017-09-18.
 */
public class UserUtils {

    public static String getUsername() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .map(principal -> (User) principal)
                .map(User::getUsername)
                .orElse("anonymous");
    }
}
