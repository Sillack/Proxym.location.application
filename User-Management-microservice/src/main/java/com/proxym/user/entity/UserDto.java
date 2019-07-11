package com.proxym.user.entity;

import com.proxym.user.emum.UserTypeEnum;

public class UserDto {

    private Integer id;
    private String full_name;
    private UserTypeEnum user_type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public UserTypeEnum getUser_type() {
        return user_type;
    }

    public void setUser_type(UserTypeEnum user_type) {
        this.user_type = user_type;
    }
}
