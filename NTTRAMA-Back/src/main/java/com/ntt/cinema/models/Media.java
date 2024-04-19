package com.ntt.cinema.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp added_date;
    private String media;
    private String media_type;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    public Media() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Timestamp added_date) {
        this.added_date = added_date;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Media{" +
                "id=" + id +
                ", added_date=" + added_date +
                ", media='" + media + '\'' +
                ", media_type='" + media_type + '\'' +
                ", film=" + film +
                '}';
    }
}
