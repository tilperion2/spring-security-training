package com.tilperion.security.dto;

import com.tilperion.security.model.Authority;
import com.tilperion.security.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class CreateUserDto {

    public String username;
    public String password;

    public List<String> authorities;

}
