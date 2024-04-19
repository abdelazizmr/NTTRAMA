package com.ntt.cinema.models;

import jakarta.persistence.*;

@Entity
public class Director{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    public Director() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Artist getArtist() {
        return artist;
    }
    public void setArtist(Artist artist) {
        this.artist = artist;
    }
    public Film getFilm() {
        return film;
    }
    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", artist=" + artist +
                ", film=" + film +
                '}';
    }
}
