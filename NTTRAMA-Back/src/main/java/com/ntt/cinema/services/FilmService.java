package com.ntt.cinema.services;

import com.ntt.cinema.models.Film;
import com.ntt.cinema.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Optional<Film> getFilmById(int id) {
        return filmRepository.findById(id);
    }

    public Film createOrUpdateFilm(Film film) {
        return filmRepository.save(film);
    }

    public void deleteFilmById(int id) {
        filmRepository.deleteById(id);
    }
}
