package com.ntt.cinema.repositories;

import com.ntt.cinema.models.Film;
import com.ntt.cinema.models.Media;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MediaRepository extends JpaRepository<Media, Integer> {
    List<Media> findByFilm(Optional<Film> film);
}
