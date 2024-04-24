package com.ntt.cinema.dto;


import com.ntt.cinema.models.Artist;
import com.ntt.cinema.models.Film;
import com.ntt.cinema.models.Genre;
import com.ntt.cinema.models.Nationality;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Timestamp;


@Projection(name = "inlineFilm", types = { Film.class })
public interface InlineFilm {
    Long getId();
    String getTitle();
    Timestamp getAdded_date();
    int getYear();
    int getDuration();
    Artist getDirector();
    Genre getGenre();
    Nationality getNationality();
}
