package com.ntt.cinema.repositories;

import com.ntt.cinema.dto.InlineFilm;
import com.ntt.cinema.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@Repository
@RepositoryRestResource(excerptProjection = InlineFilm.class)
public interface FilmRepository extends JpaRepository<Film, Integer> {
    // Method to find films by title
//    List<Film> findByTitle(String title);

    // Method to find films by title containing a certain keyword
    List<Film> findByTitleContaining(String keyword);

    // Method to find films and order them by rating ascending
    List<Film> findAllByOrderByRatingsAsc();

    // Method to find films and order them by rating descending
    List<Film> findAllByOrderByRatingsDesc();

    List<Film> findByTitle(String title);

    List<Film> findByNationality(Nationality nationality);

    List<Film> findByGenre(Genre genre);
}
