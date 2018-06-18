package com.santa.converter;

import com.santa.dto.UserDto;
import com.santa.entity.User;
import org.springframework.beans.BeanUtils;

public class UserConverter {

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        BeanUtils.copyProperties(user, dto);
        return dto;
    }

    public static User fromDto(UserDto dto) {
        User user = new User();
        BeanUtils.copyProperties(dto, user);
        return user;
    }
}
