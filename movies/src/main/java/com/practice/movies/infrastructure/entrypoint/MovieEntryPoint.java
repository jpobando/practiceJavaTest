package com.practice.movies.infrastructure.entrypoint;

import com.practice.movies.domain.model.movie.Movie;
import com.practice.movies.domain.usecase.CategoryUseCase;
import com.practice.movies.domain.usecase.MovieUseCase;
import com.practice.movies.infrastructure.entrypoint.dto.MovieDto;
import com.practice.movies.infrastructure.entrypoint.dto.ResponseDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/movie")
public class MovieEntryPoint {

    private final MovieUseCase movieUseCase;
    private final CategoryUseCase categoryUseCase;

    @PostMapping
    public ResponseDto<?> saveMovie(@RequestBody @Valid MovieDto movieDto){

        Movie movie = movieUseCase.save(MovieDto.toDomain(movieDto));
        return ResponseDto.builder()
                .data(MovieDto.fromDomain(movie))
                .status(HttpStatus.OK.value())
                .message("Respuesta OK")
                .build();
    }
}
