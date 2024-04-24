package com.ntt.cinema.services;

import com.ntt.cinema.models.Artist;
import com.ntt.cinema.models.Customer;
import com.ntt.cinema.models.Film;
import com.ntt.cinema.models.Media;
import com.ntt.cinema.repositories.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {
    private final MediaRepository mediaRepository;

    @Autowired
    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public List<Media> getMediasForFilm(Optional<Film> film) {
        return mediaRepository.findByFilm(film);
    }
    public List<Media> getAllMedias() {
        return mediaRepository.findAll();
    }

    public void deleteMediaById(int id) {
        mediaRepository.deleteById(id);
    }

    public Media createOrUpdateMedia(Media media) {
        return mediaRepository.save(media);
    }

    public Optional<Media> getMediaById(int id) {
        return mediaRepository.findById(id);
    }


}
