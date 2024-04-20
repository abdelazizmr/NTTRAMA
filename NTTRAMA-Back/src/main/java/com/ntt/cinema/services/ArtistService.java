package com.ntt.cinema.services;

import com.ntt.cinema.models.Artist;
import com.ntt.cinema.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Optional<Artist> getArtistById(int id) {
        return artistRepository.findById(id);
    }

    public Artist createOrUpdateArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public void deleteArtistById(int id) {
        artistRepository.deleteById(id);
    }
}
