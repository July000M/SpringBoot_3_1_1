package com.example.springboot_3_1_1.mapper;

import com.example.springboot_3_1_1.dto.UserDto;
import com.example.springboot_3_1_1.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDTO(User userModel);

    User toModel(UserDto userDto);
}
