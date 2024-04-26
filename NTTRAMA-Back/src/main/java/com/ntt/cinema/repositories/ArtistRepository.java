package com.ntt.cinema.repositories;

import com.ntt.cinema.models.Artist;
import com.ntt.cinema.models.ArtistType;
import com.ntt.cinema.models.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    List<Artist> findByFirstName(String keyword);

    List<Artist> findByNationality(Nationality nationality);

    List<Artist> findByArtistType(ArtistType type);
}
