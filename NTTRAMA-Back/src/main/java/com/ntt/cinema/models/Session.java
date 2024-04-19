package com.ntt.cinema.models;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate projection_date;
    private Time start_time;
    private Time end_time;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "movieRoom_id")
    private MovieRoom movieRoom;

    public Session() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getProjection_date() {
        return projection_date;
    }

    public void setProjection_date(LocalDate projection_date) {
        this.projection_date = projection_date;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public MovieRoom getMovieRoom() {
        return movieRoom;
    }

    public void setMovieRoom(MovieRoom movieRoom) {
        this.movieRoom = movieRoom;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", projection_date=" + projection_date +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", film=" + film +
                ", movieRoom=" + movieRoom +
                '}';
    }
}
