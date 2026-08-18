package com.api.techchristian.ms.user.database.repository;

import com.api.techchristian.ms.user.database.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
