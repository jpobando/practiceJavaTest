package com.practice.movies.domain.usecase.gateway;

import com.practice.movies.domain.model.movie.Movie;

public interface IMovieRepository {
    Movie saveMovie(Movie movie);
}
