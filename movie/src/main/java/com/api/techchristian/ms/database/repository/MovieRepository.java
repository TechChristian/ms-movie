package com.api.techchristian.ms.database.repository;

import com.api.techchristian.ms.database.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MovieRepository extends JpaRepository<MovieEntity, UUID> {
    boolean existsByTitle (String title);
}
