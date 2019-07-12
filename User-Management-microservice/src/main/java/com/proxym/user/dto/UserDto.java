package com.proxym.user.dto;

/**
 * @author Anis OURAJINI
 */
import com.proxym.user.emum.UserTypeEnum;

public class UserDto {

    private Integer id;
    private String full_name;
    private UserTypeEnum user_type;
    private String address;
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, String full_name, UserTypeEnum user_type, String address, String email) {
        this.id = id;
        this.full_name = full_name;
        this.user_type = user_type;
        this.address = address;
        this.email = email;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
