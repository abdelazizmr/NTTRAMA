package com.ntt.cinema.services;

import com.ntt.cinema.models.MovieRoom;
import com.ntt.cinema.repositories.MovieRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MovieRoomService {
    private final MovieRoomRepository movieRoomRepository;

    @Autowired
    public MovieRoomService(MovieRoomRepository movieRoomRepository) {
        this.movieRoomRepository = movieRoomRepository;
    }

    public List<MovieRoom> getAllMovieRooms() {
        return movieRoomRepository.findAll();
    }

    public Optional<MovieRoom> getMovieRoomById(int id) {
        return movieRoomRepository.findById(id);
    }

    public MovieRoom createOrUpdateMovieRoom(MovieRoom movieRoom) {
        return movieRoomRepository.save(movieRoom);
    }

    public void deleteMovieRoomById(int id) {
        movieRoomRepository.deleteById(id);
    }

}
