package com.ntt.cinema.controllers;

import com.ntt.cinema.models.Customer;
import com.ntt.cinema.models.Film;
import com.ntt.cinema.services.CustomerService;
import com.ntt.cinema.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Controller
public class FilmController {
    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @GetMapping("/films")
    public String getAllFilms(Model model) {
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("films", films);
        return "films";
    }

    @PostMapping("/customers")
    public String createOrUpdateFilm(@ModelAttribute("film") Film film) {
        film.setAdded_date(new Timestamp(System.currentTimeMillis()));
        filmService.createOrUpdateFilm(film);
        return "redirect:/films";
    }

    @PostMapping("/{id}")
    public String deleteFilm(@PathVariable int id) {
        filmService.deleteFilmById(id);
        return "redirect:/films";
    }
}


