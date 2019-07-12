package com.proxym.user.service;

/**
 * @author Anis OURAJINI
 */

import com.proxym.user.entity.User;

import java.util.List;


public interface UserService {


    List<User> getAllUsers();

    User addUser(User user);

    void deleteUserById(Integer id);

    User getUserById(Integer id);


}
