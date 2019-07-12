package com.proxym.user.controller;

/**
 * @author Anis OURAJINI
 */

import com.proxym.user.dto.UserDto;
import com.proxym.user.entity.User;
import com.proxym.user.feign.client.UserManagementFeignClient;
import com.proxym.user.service.UserServiceImplementation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(value = "User Management Service")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImplementation userServiceImplementation;

    @Autowired
    UserManagementFeignClient userManagementFeignClient;

    @Autowired
    private ModelMapper modelMapper;

    @ApiOperation(value = "View a list of available users", response = List.class)

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        List<User> users = userServiceImplementation.getAllUsers();
        return users.stream()
                .map(user -> convertToDto(user))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Add user")
    @PostMapping("/adduser")
    public UserDto addNewUser(@RequestBody UserDto userDto) throws ParseException {
        User user = convertToEntity(userDto);
        User userCreated = userServiceImplementation.addUser(user);
        return convertToDto(userCreated);
    }

    @ApiOperation(value = "Get user by Id")
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable(value = "id") Integer id) {

        return convertToDto(userServiceImplementation.getUserById(id));

    }

    @ApiOperation(value = "Get locations by user")
    @GetMapping("/{id_user}/locations")
    public String getLocationsByUser(@PathVariable(value = "id_user") Integer id_user) {
        return userManagementFeignClient.getLocationsByUser(id_user);
    }

    @ApiOperation(value = "Delete user by id")
    @DeleteMapping("/user/delete/{id}")
    public void deleteUserById(@PathVariable(value = "id") Integer id) {
        userServiceImplementation.deleteUserById(id);
    }



    private UserDto convertToDto(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    private User convertToEntity(UserDto userDto) throws ParseException {
        User user = modelMapper.map(userDto, User.class);
        return user;
    }

}
