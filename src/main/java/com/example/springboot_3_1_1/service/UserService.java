package com.example.springboot_3_1_1.service;


import com.example.springboot_3_1_1.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    void saveUser(UserDto userDto);
    UserDto getUser(int id);
    void deleteUser(int id);
}
