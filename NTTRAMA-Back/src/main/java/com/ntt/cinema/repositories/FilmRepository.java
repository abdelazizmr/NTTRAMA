package com.ntt.cinema.repositories;

import com.ntt.cinema.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}
