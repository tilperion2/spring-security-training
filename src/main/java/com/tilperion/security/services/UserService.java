package com.tilperion.security.services;

import com.tilperion.security.dto.CreateUserDto;
import com.tilperion.security.dto.UserDto;
import com.tilperion.security.model.Authority;
import com.tilperion.security.model.User;
import com.tilperion.security.repo.AuthoritiesRepository;
import com.tilperion.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).collect(Collectors.toList());
    }

    public UserDto getUserByName(String username) {
        return userRepository.findByUsername(username).map(UserDto::fromEntity).orElseThrow();
    }

    public UserDto createUser(CreateUserDto newUser) {
        User user = new User(newUser.username, passwordEncoder.encode(newUser.password), null);
        List<Authority> authorities = newUser.authorities.stream()
                .map(a -> new Authority(a, user))
                .toList();
        user.setAuthorities(authorities);

        return UserDto.fromEntity(userRepository.save(user));
    }
}
