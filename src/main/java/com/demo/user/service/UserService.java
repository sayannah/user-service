package com.demo.user.service;

import com.demo.user.model.User;
import com.demo.user.repo.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserJpaRepo userJpaRepo;

    public List<User> getUserDetails() {
        return userJpaRepo.findAll();
    }

    public User saveUserDetails(User user) {
        return userJpaRepo.save(user);
    }

    public User updateUserDetails(Integer userId, User user) {
        List<User> userList = (List<User>) getUserDetails();
        User existingUser= userList.stream().filter(u -> u.getUserId().equals(userId))
                .findFirst().orElse(null);
        if (existingUser != null && existingUser.isActive()) {
            existingUser.setUserName(user.getUserName());
            existingUser.setPassword(user.getPassword());
            return userJpaRepo.save(existingUser);
        }
        return existingUser;
    }

    public void deleteUserDetails(Integer userId) {
        List<User> userList = (List<User>) getUserDetails();
        User existingUser= userList.stream().filter(u -> u.getUserId().equals(userId))
                .findFirst().orElse(null);
        if (existingUser != null && existingUser.isActive()) {
            existingUser.setActive(false);
            userJpaRepo.deleteById(userId);
        }
    }
}
