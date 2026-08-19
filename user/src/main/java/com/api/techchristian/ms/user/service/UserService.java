package com.api.techchristian.ms.user.service;

import com.api.techchristian.ms.user.database.model.UserEntity;
import com.api.techchristian.ms.user.database.repository.UserRepository;
import com.api.techchristian.ms.user.dto.UserDto;
import com.api.techchristian.ms.user.exception.EmailAlreadyExistsException;
import com.api.techchristian.ms.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserDto.response addUser(UserDto.create createUser){

        // Transforms User Dto to User Entity.
        UserEntity userRequestToEntity = UserMapper.toEntity(createUser);

        // Verify in User Repository the existence of Email in Database.
        boolean existsEmail = userRepository.existsByEmail(userRequestToEntity.getEmail());
        if(existsEmail) {throw new EmailAlreadyExistsException("E-mail already exists");}

        // Saved User in Database
        var savedUser = userRepository.save(userRequestToEntity);

        // return entity persists in Database.
        return UserMapper.toResponse(savedUser);
    }
}
