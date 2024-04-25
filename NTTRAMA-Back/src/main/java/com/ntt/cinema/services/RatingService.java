package com.ntt.cinema.services;

import com.ntt.cinema.models.Film;
import com.ntt.cinema.models.Rating;
import com.ntt.cinema.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<Rating> getRatingsForFilm(Optional<Film> film) {
        return ratingRepository.findByFilm(film);
    }
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }
}
