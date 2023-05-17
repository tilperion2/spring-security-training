package com.tilperion.security.controllers;

import com.tilperion.security.dto.UserDto;
import com.tilperion.security.model.User;
import com.tilperion.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/users/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @PostMapping("/add")
    public String addUser(UserDto newUser) {
        return "Created user, id = " + 42L;
    }
}
