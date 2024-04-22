package com.ntt.cinema.repositories;

import com.ntt.cinema.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
}
