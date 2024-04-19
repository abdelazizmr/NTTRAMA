package com.ntt.cinema.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int customer_id;
    private String comment;
    private int score;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", comment='" + comment + '\'' +
                ", score=" + score +
                ", film=" + film +
                '}';
    }
}
