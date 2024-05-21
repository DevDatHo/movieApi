package dev.datho.movies.repositories;

import dev.datho.movies.models.Movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface MovieRepository extends MongoRepository<Movies, ObjectId> {

    Optional<Movies> findMovieByImdbId(String imdbId);
}
