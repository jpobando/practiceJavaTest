package com.practice.movies.domain.usecase;

import com.practice.movies.domain.model.movie.Movie;
import com.practice.movies.domain.usecase.gateway.IMovieRepository;
import org.springframework.stereotype.Component;

@Component
public class MovieUseCase {
    private IMovieRepository iMovieRepository;

    public MovieUseCase(IMovieRepository iMovieRepository) {
        this.iMovieRepository = iMovieRepository;
    }

    public Movie save(Movie movie){
        return iMovieRepository.saveMovie(movie);
    }
}
