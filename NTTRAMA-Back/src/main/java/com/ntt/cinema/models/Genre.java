package com.ntt.cinema.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String genre_name;

    @OneToMany(mappedBy = "genre",fetch = FetchType.EAGER)
    private List<Film> films;

    public Genre() {
    }

    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre_name='" + genre_name + '\'' +
                '}';
    }
}
