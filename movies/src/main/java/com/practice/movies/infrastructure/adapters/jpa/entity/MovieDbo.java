package com.practice.movies.infrastructure.adapters.jpa.entity;

import com.practice.movies.domain.model.movie.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name="movie")
public class MovieDbo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movieId;
    private String title;
    private String description;
    private Integer duration;
    private Integer score;
    @ManyToOne
    @JoinColumn(name="category_id")
    private CategoryDbo categoryId;

    public static MovieDbo fromDomain(Movie movie){
        return new MovieDbo(
                null,
                movie.getTitle().getValue(),
                movie.getDescription().getValue(),
                movie.getDuration().getValue(),
                movie.getScore().getValue(),
                new CategoryDbo(
                        movie.getMovieCategoryId().getValue(),
                        null)
        );
    }

    public static Movie toDomain(MovieDbo movieDbo){
        return new Movie(
                new MovieId(movieDbo.getMovieId()),
                new Title(movieDbo.getTitle()),
                new Description(movieDbo.getDescription()),
                new Duration(movieDbo.getDuration()),
                new Score(movieDbo.getScore()),
                new MovieCategoryId(movieDbo.getCategoryId().getId())
        );
    }
}
