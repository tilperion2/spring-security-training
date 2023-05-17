package com.tilperion.security.dto;

import com.tilperion.security.model.Authority;
import com.tilperion.security.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    public Long id;
    public String username;
    public List<String> authorities;

    public static UserDto fromEntity(User user) {
        UserDto userDto = new UserDto();
        userDto.id = user.getId();
        userDto.username = user.getUsername();
        userDto.authorities = user.getAuthorities().stream().map(Authority::getName).collect(Collectors.toList());
        return userDto;
    }
}
