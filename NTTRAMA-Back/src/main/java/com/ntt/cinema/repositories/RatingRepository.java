package com.ntt.cinema.repositories;

import com.ntt.cinema.models.Film;
import com.ntt.cinema.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;


@CrossOrigin("http://localhost:4200")
@Repository
@RepositoryRestResource
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    List<Rating> findByFilm(Optional<Film> film);
}
