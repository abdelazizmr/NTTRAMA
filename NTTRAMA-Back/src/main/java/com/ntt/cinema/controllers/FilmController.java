package com.ntt.cinema.controllers;

import com.ntt.cinema.models.Artist;
import com.ntt.cinema.models.Film;
import com.ntt.cinema.models.Genre;
import com.ntt.cinema.models.Nationality;
import com.ntt.cinema.services.ArtistService;
import com.ntt.cinema.services.FilmService;
import com.ntt.cinema.services.GenreService;
import com.ntt.cinema.services.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class FilmController {
    private final FilmService filmService;
    private final NationalityService nationalityService;
    private final ArtistService artistService;
    private final GenreService genreService;


    @Autowired
    public FilmController(FilmService filmService, NationalityService nationalityService
            , ArtistService artistService, GenreService genreService) {
        this.filmService = filmService;
        this.nationalityService = nationalityService;
        this.artistService = artistService;
        this.genreService = genreService;
    }

    @GetMapping("/films")
    public String getAllFilms(Model model) {
        List<Film> films = filmService.getAllFilms();
        List<Nationality> nationalities = nationalityService.getAllNationalities();
        List<Artist> artists = artistService.getAllArtists();
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("films", films);
        model.addAttribute("nationalities", nationalities);
        model.addAttribute("artists", artists);
        model.addAttribute("genres", genres);
        return "films";
    }

    @PostMapping("/films")
    public String createOrUpdateFilm(@ModelAttribute("film") Film film) {
        film.setAdded_date(new Timestamp(System.currentTimeMillis()));
        filmService.createOrUpdateFilm(film);
        return "redirect:/films";
    }

    @PostMapping("/films/{id}")
    public String deleteFilm(@PathVariable int id) {
        filmService.deleteFilmById(id);
        return "redirect:/films";
    }
}


