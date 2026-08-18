package com.api.techchristian.ms.user.mapper;

import com.api.techchristian.ms.user.database.model.UserEntity;
import com.api.techchristian.ms.user.dto.UserDto;

public class UserMapper {
    public UserEntity toEntity(UserDto.create userCreateDto) {
        return UserEntity.builder()
                .name(userCreateDto.name())
                .email(userCreateDto.email())
                .build();
    }

    public UserDto.response toResponse(UserEntity userEntity) {
        return new UserDto.response(
                userEntity.getName(),
                userEntity.getEmail()
        );
    }
}