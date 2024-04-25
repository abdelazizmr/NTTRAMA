package com.ntt.cinema.repositories;

import com.ntt.cinema.models.MovieRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRoomRepository extends JpaRepository<MovieRoom, Integer> {
}
