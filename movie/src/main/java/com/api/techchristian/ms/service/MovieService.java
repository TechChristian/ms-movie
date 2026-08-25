package com.api.techchristian.ms.service;

import com.api.techchristian.ms.database.model.MovieEntity;
import com.api.techchristian.ms.database.repository.MovieRepository;
import com.api.techchristian.ms.dto.MovieDto;
import com.api.techchristian.ms.exception.MovieAlreadyExistsException;
import com.api.techchristian.ms.exception.MoviesNotFoundException;
import com.api.techchristian.ms.mapper.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

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

    @Transactional(readOnly = true)
    public List<MovieDto.response> getAllMovies(){
        var allMovies = movieRepository.findAll();

        if(allMovies.isEmpty()){
            throw new MoviesNotFoundException("movies not found.");
        }

        return MovieMapper.toResponseList(allMovies);
    }
    @Transactional
    public MovieDto.response getMovie(UUID movieId){
        MovieEntity movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MoviesNotFoundException(
                        "The Movie does not exist: " + movieId
                ));

        return MovieMapper.toResponse(movie);
    }

    @Transactional
    public void deleteMovie(UUID movieId) {

        MovieEntity movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MoviesNotFoundException(
                        "The Movie does not exist: " + movieId
                ));

        movieRepository.delete(movie);

    }
}
