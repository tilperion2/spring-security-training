package com.tilperion.security.services;

import com.tilperion.security.dto.UserDto;
import com.tilperion.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUsers() {
        return Collections.emptyList();
    }
}
