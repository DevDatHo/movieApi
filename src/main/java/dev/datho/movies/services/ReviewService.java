package dev.datho.movies.services;

import dev.datho.movies.models.Reviews;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    public Reviews createReview(String reviewBody, String imdbId);
}
