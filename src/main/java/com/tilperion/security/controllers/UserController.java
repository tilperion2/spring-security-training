package com.tilperion.security.controllers;

import com.tilperion.security.dto.UserDto;
import com.tilperion.security.model.User;
import com.tilperion.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    @PostMapping("/add")
    public User addUser(@RequestBody UserDto newUser) {
        User user = new User(newUser.username, passwordEncoder.encode(newUser.password), List.of());
        return userRepository.save(user);
    }
}
