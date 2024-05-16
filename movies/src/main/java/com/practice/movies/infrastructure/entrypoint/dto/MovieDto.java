package com.practice.movies.infrastructure.entrypoint.dto;

import com.practice.movies.domain.model.movie.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class MovieDto {

    private Integer id;
    @NotBlank(message = "El título no puede estar vacío")
    @Size(max = 100, message= "El título debe tener máximo 100 caracteres")
    private String title;
    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(max = 200, message= "El título debe tener máximo 100 caracteres")
    private String description;
    @NotNull(message = "La duración no puede estar vacía")
    private Integer duration;
    @NotNull(message = "El score no puede estar vacía")
    @Min(value = 1, message = "Valor mínimo del score es 1")
    @Max(value = 5, message = "Valor máximo del score es 5")
    @Digits(integer = 1, fraction = 0, message = "El score solo puede ser un número entero")
    private Integer score;
    @NotNull(message = "La categoría no puede estar vacío")
    private Integer categoryId;

    public static Movie toDomain(MovieDto movieDto){
        return new Movie(
            null,
            new Title(movieDto.getTitle()),
            new Description(movieDto.getDescription()),
            new Duration(movieDto.getDuration()),
            new Score(movieDto.getScore()),
            new MovieCategoryId(movieDto.getCategoryId())
        );
    }
    public static MovieDto fromDomain(Movie movie){
        return new MovieDto(
            movie.getMovieId().getValue(),
            movie.getTitle().getValue(),
            movie.getDescription().getValue(),
            movie.getDuration().getValue(),
            movie.getScore().getValue(),
            movie.getMovieCategoryId().getValue()
        );
    }
}
