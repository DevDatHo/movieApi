package dev.datho.movies.services;

import dev.datho.movies.models.Movies;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    public List<Movies> getAllMovies();
    public Optional<Movies> getMovieById(String imdbId);
}
