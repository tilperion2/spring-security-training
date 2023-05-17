package com.tilperion.security.controllers;

import com.tilperion.security.dto.CreateUserDto;
import com.tilperion.security.dto.UpdateUserDto;
import com.tilperion.security.dto.UserDto;
import com.tilperion.security.model.User;
import com.tilperion.security.repo.UserRepository;
import com.tilperion.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{username}")
    public UserDto getUserByUsername(@PathVariable String username) {
        return userService.getUserByName(username);
    }

    @GetMapping("/current")
    public Authentication getUserByUsername(Authentication auth) {
        return auth;
    }

    @PostMapping("/update")
    @PreAuthorize("authentication.name == #user.username")
    public UserDto updateProfile(@RequestBody UpdateUserDto user) {
        return userService.updateUser(user);
    }

    @PostMapping("/add")
    @PreAuthorize("@authManager.isRoleCheckOk(authentication.name)")
    public UserDto addUser(@RequestBody CreateUserDto newUser) {
        return userService.createUser(newUser);
    }
}
