package com.api.techchristian.ms.user.controller;

import com.api.techchristian.ms.user.dto.UserDto;
import com.api.techchristian.ms.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto.response> createUser(@Valid @RequestBody UserDto.create create) {
        UserDto.response savedUser = userService.addUser(create);

        log.info("User created: {}", savedUser);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto.response> getUser(@PathVariable UUID id) {
        UserDto.response user = userService.getUser(id);
        log.info("User get: {}", user);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }
}
