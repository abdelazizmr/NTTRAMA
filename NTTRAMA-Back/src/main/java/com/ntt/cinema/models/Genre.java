package com.ntt.cinema.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String genre_name;

    @OneToMany(mappedBy = "genre")
    private List<Film> films;

    public Genre() {
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre_name='" + genre_name + '\'' +
                '}';
    }
}
