package dev.datho.movies.services.serviceImplement;

import dev.datho.movies.models.Movies;
import dev.datho.movies.models.Reviews;
import dev.datho.movies.repositories.ReviewRepository;
import dev.datho.movies.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImp implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    private MongoTemplate mongoTemplate;
    @Override
    public Reviews createReview(String reviewBody, String imdbId) {
        Reviews review = new Reviews(reviewBody);
        reviewRepository.insert(review);
        mongoTemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewsIds", review))
                .first();
        return review;
    }
}
