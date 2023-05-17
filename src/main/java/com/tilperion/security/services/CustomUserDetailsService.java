package com.tilperion.security.services;

import com.tilperion.security.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService {
    @Autowired
    private UserRepository userRepository;


}
