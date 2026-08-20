package com.api.techchristian.ms.mapper;

import com.api.techchristian.ms.database.model.MovieEntity;
import com.api.techchristian.ms.dto.MovieDto;

public class MovieMapper {
    public static MovieEntity toEntity (MovieDto.create movieCreateDto){
        return MovieEntity.builder()
                .title(movieCreateDto.title())
                .description(movieCreateDto.description())
                .genre(movieCreateDto.genre())
                .releaseYear(movieCreateDto.releaseYear())
                .build();
    }
    public static MovieDto.response toResponse(MovieEntity movieEntity){
        return new MovieDto.response(
                movieEntity.getMovieId(),
                movieEntity.getTitle(),
                movieEntity.getDescription(),
                movieEntity.getGenre(),
                movieEntity.getReleaseYear()
        );
    }

}
