package com.api.techchristian.ms.service;

import com.api.techchristian.ms.database.model.MovieEntity;
import com.api.techchristian.ms.database.repository.MovieRepository;
import com.api.techchristian.ms.dto.MovieDto;
import com.api.techchristian.ms.exception.MovieAlreadyExistsException;
import com.api.techchristian.ms.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    @Transactional
    public MovieDto.response addMovie (MovieDto.create createMovie){

        MovieEntity movieRequestToEntity = MovieMapper.toEntity(createMovie);

        boolean existsMovie = movieRepository.existsByTitle(movieRequestToEntity.getTitle());

        if(existsMovie){
            throw new MovieAlreadyExistsException("The Movie already exists " + createMovie.title());
        }

        var savedMovie = movieRepository.save(movieRequestToEntity);

        return MovieMapper.toResponse(savedMovie);
    }
}
