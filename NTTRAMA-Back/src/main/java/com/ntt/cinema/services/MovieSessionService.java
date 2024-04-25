package com.ntt.cinema.services;

import com.ntt.cinema.models.MovieSession;
import com.ntt.cinema.repositories.MovieSessionRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieSessionService {
    private final MovieSessionRepository movieSessionRepository;

    @Autowired
    public MovieSessionService(MovieSessionRepository movieSessionRepository) {
        this.movieSessionRepository = movieSessionRepository;
    }

    public List<MovieSession> getAllMovieSessions() {
        return movieSessionRepository.findAll();
    }

    public Optional<MovieSession> getMovieSessionById(int id) {
        return movieSessionRepository.findById(id);
    }

    public MovieSession createOrUpdateMovieSession(MovieSession movieSession) {
        return movieSessionRepository.save(movieSession);
    }

    public void deleteMovieSessionById(int id) {
        movieSessionRepository.deleteById(id);
    }

}


