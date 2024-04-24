package com.ntt.cinema.repositories;

import com.ntt.cinema.models.Film;
import com.ntt.cinema.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByFilm(Optional<Film> film);
}
