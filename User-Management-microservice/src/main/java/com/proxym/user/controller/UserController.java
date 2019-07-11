package com.proxym.user.controller;

import com.proxym.user.dto.Dto;
import com.proxym.user.entity.User;
import com.proxym.user.entity.UserDto;
import com.proxym.user.service.UserService;
import io.swagger.annotations.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@Api(value = "User Management Service")
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

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
    @Dto(UserDto.class)
    public List<UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream()
                .map(user -> convertToDto(user))
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Add an user")
    @PostMapping("/adduser")
    @Dto(UserDto.class)
    public UserDto addNewUser(@RequestBody User user) {

        return convertToDto(this.userService.addUser(user));
    }


    @ApiOperation(value = "Get user by Id")
    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getEmployeeById(
            @ApiParam(value = "user id from which user object will retrieve", required = true) @PathVariable(value = "id") Integer user_id) {
        Optional<User> user = userService.findById(user_id);
        return ResponseEntity.ok().body(user);
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
