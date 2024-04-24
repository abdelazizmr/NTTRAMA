package com.ntt.cinema.controllers;


import com.ntt.cinema.models.Film;
import com.ntt.cinema.models.MovieRoom;
import com.ntt.cinema.models.MovieSession;
import com.ntt.cinema.services.FilmService;
import com.ntt.cinema.services.MovieRoomService;
import com.ntt.cinema.services.MovieSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class MovieSessionController {
    private final MovieSessionService movieSessionService;
    private final MovieRoomService movieRoomService;
    private final FilmService filmService;
    @Autowired
    public MovieSessionController(MovieSessionService movieSessionService, MovieRoomService movieRoomService
            , FilmService filmService) {
        this.movieSessionService = movieSessionService;
        this.movieRoomService = movieRoomService;
        this.filmService = filmService;
    }

    @GetMapping("/movie-sessions")
    public String getAllSessions(Model model) {
        List<MovieSession> movieSessions = movieSessionService.getAllMovieSessions();
        List<MovieRoom> movieRooms = movieRoomService.getAllMovieRooms();
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("movieSessions", movieSessions);
        model.addAttribute("movieRooms", movieRooms);
        model.addAttribute("films", films);
        return "movie-sessions";
    }

    @PostMapping("/movie-sessions")
    public String createOrUpdateMovieSession(@ModelAttribute("movieSession") MovieSession movieSession) {
        Optional<MovieSession> existingMovieSession = movieSessionService.getMovieSessionById(movieSession.getId());
        if (existingMovieSession.isPresent()) {
            MovieSession existing = existingMovieSession.get();
            existing.setProjection_date(movieSession.getProjection_date());
            existing.setStart_time(movieSession.getStart_time());
            existing.setEnd_time(movieSession.getEnd_time());
            existing.setFilm(movieSession.getFilm());
            existing.setMovieRoom(movieSession.getMovieRoom());
            movieSessionService.createOrUpdateMovieSession(existing);
        } else {
            movieSessionService.createOrUpdateMovieSession(movieSession);
        }
        return "redirect:/movie-sessions";
    }

    @PostMapping("/movie-sessions/{id}")
    public String deleteSession(@PathVariable int id) {
        movieSessionService.deleteMovieSessionById(id);
        return "redirect:/movie-sessions";
    }
}

