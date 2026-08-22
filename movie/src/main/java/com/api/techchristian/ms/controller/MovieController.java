package com.api.techchristian.ms.controller;

import com.api.techchristian.ms.dto.MovieDto;
import com.api.techchristian.ms.service.MovieService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/movies")
@RequiredArgsConstructor
@Slf4j
public class MovieController {
    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<MovieDto.response> addMovie(@RequestBody @Valid MovieDto.create createMovie) {
        MovieDto.response responseMovie = movieService.addMovie(createMovie);
        log.info("Movie added : {}", responseMovie);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMovie);
    }

    @GetMapping
    public ResponseEntity<List<MovieDto.response>> getAllMovies() {
        List<MovieDto.response> responseMovies = movieService.getAllMovies();
        log.info("All movies found : {}", responseMovies);

        return ResponseEntity.status(HttpStatus.OK).body(responseMovies);
    }
}
