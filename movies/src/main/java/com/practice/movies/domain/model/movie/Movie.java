package com.practice.movies.domain.model.movie;

import com.practice.movies.domain.model.category.CategoryId;

public class Movie {
    private final MovieId movieId;
    private final Title title;
    private final Description description;
    private final Duration duration;
    private final Score score;
    private final MovieCategoryId movieCategoryId;

    public Movie(MovieId movieId, Title title, Description description, Duration duration, Score score, MovieCategoryId movieCategoryId) {
        this.movieId = movieId;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.score = score;
        this.movieCategoryId = movieCategoryId;
    }

    public MovieId getMovieId() {
        return movieId;
    }

    public Title getTitle() {
        return title;
    }

    public Description getDescription() {
        return description;
    }

    public Duration getDuration() {
        return duration;
    }

    public Score getScore() {
        return score;
    }

    public MovieCategoryId getMovieCategoryId() {
        return movieCategoryId;
    }
}
