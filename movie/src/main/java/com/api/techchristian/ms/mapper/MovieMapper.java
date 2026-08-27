package com.api.techchristian.ms.mapper;

import com.api.techchristian.ms.database.model.MovieEntity;
import com.api.techchristian.ms.dto.MovieDto;

import java.util.List;

public class MovieMapper {
    public static MovieEntity toEntity (MovieDto.create movieCreateDto){
        return MovieEntity.builder()
                .title(movieCreateDto.title())
                .description(movieCreateDto.description())
                .genre(movieCreateDto.genre())
                .sessionTime(movieCreateDto.sessionTime())
                .price(movieCreateDto.price())
                .releaseYear(movieCreateDto.releaseYear())
                .build();
    }
    public static MovieDto.response toResponse(MovieEntity movieEntity){
        return new MovieDto.response(
                movieEntity.getMovieId(),
                movieEntity.getTitle(),
                movieEntity.getDescription(),
                movieEntity.getGenre(),
                movieEntity.getSessionTime(),
                movieEntity.getPrice(),
                movieEntity.getReleaseYear()
        );
    }
    public static List<MovieDto.response> toResponseList(List<MovieEntity> movieEntityList){
        return movieEntityList
                .stream()
                .map(MovieMapper::toResponse)
                .toList();
    }

}
