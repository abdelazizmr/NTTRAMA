package com.ntt.cinema.repositories;

import com.ntt.cinema.models.Artist;
import com.ntt.cinema.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
}
