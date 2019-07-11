package com.proxym.user.entity;

import com.proxym.user.emum.UserTypeEnum;

import javax.persistence.*;
import javax.validation.constraints.Email;


@Entity
@Table(name = "users")
public class User {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "FULL_NAME", nullable = true, length = 255)
    private String full_name;
    @Column(name = "USER_TYPE")
    @Enumerated(EnumType.STRING)
    private UserTypeEnum user_type;
    @Column(name = "ADDRESS", nullable = true, length = 255)
    private String address;
    @Column(name = "EMAIL", nullable = false, unique = true, length = 255)
    @Email
    private String email;

    protected User() {
    }
    /*@CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date modifiedAt;*/

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


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", user_type='" + user_type + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
