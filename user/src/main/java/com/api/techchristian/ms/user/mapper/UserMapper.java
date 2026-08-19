package com.api.techchristian.ms.user.mapper;

import com.api.techchristian.ms.user.database.model.UserEntity;
import com.api.techchristian.ms.user.dto.UserDto;

public class UserMapper {
    public static UserEntity toEntity(UserDto.create userCreateDto) {
        return UserEntity.builder()
                .name(userCreateDto.name())
                .email(userCreateDto.email())
                .build();
    }

    public static UserDto.response toResponse(UserEntity userEntity) {
        return new UserDto.response(
                userEntity.getUserId(),
                userEntity.getName(),
                userEntity.getEmail()
        );
    }
}