package com.practice.movies.infrastructure.adapters.jpa.movie;

import com.practice.movies.infrastructure.adapters.jpa.entity.MovieDbo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieAdapterRepository extends JpaRepository<MovieDbo, Integer> {
}
