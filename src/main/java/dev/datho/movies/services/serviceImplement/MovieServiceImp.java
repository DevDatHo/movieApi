package dev.datho.movies.services.serviceImplement;

import dev.datho.movies.models.Movies;
import dev.datho.movies.repositories.MovieRepository;
import dev.datho.movies.services.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieServiceImp implements MovieService {
    private MovieRepository movieRepository;

    @Override
    public List<Movies> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movies> getMovieById(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}