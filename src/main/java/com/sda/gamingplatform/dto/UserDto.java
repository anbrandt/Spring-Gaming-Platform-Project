package com.sda.gamingplatform.dto;

/**
 * Created by RENT on 2017-09-21.
 */
public class UserDto {

    private String username;
    private long userId;

    public UserDto(String username, long userId) {
        this.username = username;
        this.userId = userId;
    }

    public UserDto() {
    }


    public String getUsername() {
        return username;
    }

    public long getUserId() {
        return userId;
    }
}
