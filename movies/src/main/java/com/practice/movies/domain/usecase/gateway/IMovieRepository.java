package com.practice.movies.domain.usecase.gateway;

import com.practice.movies.domain.model.movie.Movie;

import java.util.List;

public interface IMovieRepository {
    Movie saveMovie(Movie movie);
    List<Movie> getAllMovies();
}
