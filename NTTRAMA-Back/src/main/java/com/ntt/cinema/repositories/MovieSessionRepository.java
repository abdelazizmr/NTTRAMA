package com.ntt.cinema.repositories;

import com.ntt.cinema.models.MovieSession;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieSessionRepository extends JpaRepository<MovieSession, Integer> {
}
