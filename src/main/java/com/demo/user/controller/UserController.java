package com.demo.user.controller;

import com.demo.user.model.User;
import com.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired private UserService userService;

    @GetMapping("/getUserDetails")
    public List<User> getUserDetails(){
        return userService.getUserDetails();
    }

    @PostMapping("/saveUserDetails")
    public User saveUserDetails(@RequestBody User user){
        return userService.saveUserDetails(user);
    }

    @PutMapping("/updateUserDetails")
    public User updateUserDetails(@RequestParam Integer userId,@RequestBody User user){
        return userService.updateUserDetails(userId,user);
    }
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam Integer userId){
        userService.deleteUserDetails(userId);
    }
}

