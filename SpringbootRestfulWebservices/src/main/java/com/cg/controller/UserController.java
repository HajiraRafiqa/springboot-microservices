package com.cg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.cg.dto.UserDto;
import com.cg.service.UserService;

import jakarta.validation.Valid;



@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
	
	
	private UserService userService;

    // creating user
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // get user by id 
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Get All Users 
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Update UserDto 
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody UserDto user){
        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Delete UserDto 
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("UserDto successfully deleted!", HttpStatus.OK);
    }

}

