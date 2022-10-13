package com.example.springboot_3_1_1.service;


import com.example.springboot_3_1_1.dto.UserDto;
import com.example.springboot_3_1_1.mapper.UserMapper;
import com.example.springboot_3_1_1.model.User;
import com.example.springboot_3_1_1.repository.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UsersRepository usersRepository, UserMapper userMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return usersRepository.findAll().stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Transactional
    @Override
    public void saveUser(UserDto userDto) {
        usersRepository.save(userMapper.toModel(userDto));

    }

    @Override
    public UserDto getUser(int id) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.toDTO(user);
    }

    @Transactional
    @Override
    public void deleteUser(int id) {
        usersRepository.deleteById(id);
    }

}
