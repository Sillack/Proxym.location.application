package com.proxym.user.entity;

/**
 * @author Anis OURAJINI
 */
import com.proxym.user.emum.UserTypeEnum;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(name = "FULL_NAME")
    private String full_name;
    @NotNull
    @Column(name = "USER_TYPE")
    @Enumerated(EnumType.STRING)
    private UserTypeEnum user_type;
    @NotNull
    @Column(name = "ADDRESS")
    private String address;
    @NotNull
    @Column(name = "EMAIL")
    @Email
    private String email;

    protected User() {
    }

    public User(@NotNull String full_name, @NotNull UserTypeEnum user_type, @NotNull String address, @NotNull @UniqueElements @Email String email) {
        this.full_name = full_name;
        this.user_type = user_type;
        this.address = address;
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

}
