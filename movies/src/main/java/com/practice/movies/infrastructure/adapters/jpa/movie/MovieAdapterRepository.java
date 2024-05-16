package com.practice.movies.infrastructure.adapters.jpa.movie;

import com.practice.movies.domain.model.category.Category;
import com.practice.movies.domain.model.movie.Movie;
import com.practice.movies.domain.usecase.gateway.IMovieRepository;
import com.practice.movies.infrastructure.adapters.jpa.category.CategoryAdapterRepository;
import com.practice.movies.infrastructure.adapters.jpa.category.ICategoryAdapterRepository;
import com.practice.movies.infrastructure.adapters.jpa.entity.CategoryDbo;
import com.practice.movies.infrastructure.adapters.jpa.entity.MovieDbo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class MovieAdapterRepository implements IMovieRepository {
    public final IMovieAdapterRepository movieRepository;
    public final CategoryAdapterRepository categoryRepository;

    @Override
    public Movie saveMovie(Movie movie) {
        Category category = categoryRepository.getCategory(movie.getMovieCategoryId().getValue());
        MovieDbo movieToSave = new MovieDbo(
                null,
                movie.getTitle().getValue(),
                movie.getDescription().getValue(),
                movie.getDuration().getValue(),
                movie.getScore().getValue(),
                new CategoryDbo(
                        movie.getMovieCategoryId().getValue(),
                        category.getName().getValue()
                )
        );
        MovieDbo movieDbo = movieRepository.save(movieToSave);
        return MovieDbo.toDomain(movieDbo);
    }

    @Override
    public List<Movie> getAllMovies() {
        List<MovieDbo> movieListDbo = movieRepository.findAll();
        return movieListDbo.stream().map(MovieDbo::toDomain).toList();
    }
}
