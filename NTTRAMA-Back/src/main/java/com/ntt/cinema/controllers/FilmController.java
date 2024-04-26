package com.ntt.cinema.controllers;

import com.ntt.cinema.models.*;
import com.ntt.cinema.services.ArtistService;
import com.ntt.cinema.services.FilmService;
import com.ntt.cinema.services.GenreService;
import com.ntt.cinema.services.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

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
    public String createOrUpdateFilm(@ModelAttribute("film") Film film, @RequestParam("image") MultipartFile file) {
        try {
            film.setPhoto(file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Path uploadPath = Paths.get("src/main/resources/static/film-img/" + file.getOriginalFilename());
            Files.createDirectories(uploadPath.getParent());
            Files.write(uploadPath, bytes);
            film.setAdded_date(new Timestamp(System.currentTimeMillis()));
            filmService.createOrUpdateFilm(film);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/films";
    }

    @PostMapping("/films/{id}")
    public String deleteFilm(@PathVariable int id) {
        filmService.deleteFilmById(id);
        return "redirect:/films";
    }

    @GetMapping("/search-film")
    public String searchFilms(@RequestParam String title, Model model) {
        List<Film> films = filmService.searchFilmsByTitle(title);
        model.addAttribute("films", films);
        return "films";
    }

    @GetMapping("/search-nationality")
    public String searchFilmsByNationality(@RequestParam Nationality nationality, Genre genre, Model model) {
        List<Film> films = filmService.searchFilmsByNationality(nationality);
        List<Nationality> nationalities = nationalityService.getAllNationalities();
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("films", films);
        model.addAttribute("nationalities", nationalities);
        model.addAttribute("genres", genres);
        return "films";
    }

    @GetMapping("/search-genre")
    public String searchFilmsByGenre(@RequestParam Genre genre, Nationality nationality, Model model) {
        List<Film> films = filmService.searchFilmsByGenre(genre);
        List<Nationality> nationalities = nationalityService.getAllNationalities();
        List<Genre> genres = genreService.getAllGenres();
        model.addAttribute("films", films);
        model.addAttribute("nationalities", nationalities);
        model.addAttribute("genres", genres);
        return "films";
    }

}


