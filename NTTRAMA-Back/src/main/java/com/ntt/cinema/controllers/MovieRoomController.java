package com.ntt.cinema.controllers;

import com.ntt.cinema.models.MovieRoom;
import com.ntt.cinema.services.MovieRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
public class MovieRoomController {
    private final MovieRoomService movieRoomService;

    @Autowired
    public MovieRoomController(MovieRoomService movieRoomService) {
        this.movieRoomService = movieRoomService;
    }

    @GetMapping("/movie-rooms")
    public String getAllMovieRooms(Model model) {
        List<MovieRoom> movieRooms = movieRoomService.getAllMovieRooms();
        model.addAttribute("movieRooms", movieRooms);
        return "movie-rooms";
    }

    @PostMapping("/movie-rooms")
    public String createOrUpdateMovieRoom(@ModelAttribute("movieRoom") MovieRoom movieRoom) {
        Optional<MovieRoom> existingMovieRoom = movieRoomService.getMovieRoomById(movieRoom.getId());
        if (existingMovieRoom.isPresent()) {
            MovieRoom existing = existingMovieRoom.get();
            existing.setCapacity(movieRoom.getCapacity());
            existing.setRoom_number(movieRoom.getRoom_number());
            movieRoomService.createOrUpdateMovieRoom(existing);
        } else {
            movieRoom.setAdded_date(new Timestamp(System.currentTimeMillis()));
            movieRoomService.createOrUpdateMovieRoom(movieRoom);
        }
        return "redirect:/movie-rooms";
    }

    @PostMapping("/movie-rooms/{id}")
    public String deleteMovieRoom(@PathVariable int id) {
        movieRoomService.deleteMovieRoomById(id);
        return "redirect:/movie-rooms";
    }
}
