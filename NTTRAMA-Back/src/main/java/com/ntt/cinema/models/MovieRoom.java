package com.ntt.cinema.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
public class MovieRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp added_date;
    private int capacity;
    private int room_number;

    @OneToMany(mappedBy = "movieRoom")
    private List<Session> sessions;

    public MovieRoom() {
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    @Override
    public String toString() {
        return "MovieRoom{" +
                "id=" + id +
                ", added_date=" + added_date +
                ", capacity=" + capacity +
                ", room_number=" + room_number +
                ", sessions=" + sessions +
                '}';
    }
}
