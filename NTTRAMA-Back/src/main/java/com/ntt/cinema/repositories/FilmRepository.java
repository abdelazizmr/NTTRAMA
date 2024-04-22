package com.ntt.cinema.repositories;

import com.ntt.cinema.models.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("http://localhost:4200")
@Repository
//@RepositoryRestResource(exported = false)
public interface FilmRepository extends JpaRepository<Film, Integer> {
}