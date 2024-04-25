// ArtistController.java
package com.ntt.cinema.controllers;

import com.ntt.cinema.models.Artist;
import com.ntt.cinema.models.Film;
import com.ntt.cinema.models.Media;
import com.ntt.cinema.models.Nationality;
import com.ntt.cinema.services.ArtistService;
import com.ntt.cinema.services.FilmService;
import com.ntt.cinema.services.MediaService;
import com.ntt.cinema.services.NationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MediaController {

    private final MediaService mediaService;
    private final FilmService filmService;

    @Autowired
    public MediaController(MediaService mediaService, FilmService filmService) {
        this.mediaService = mediaService;
        this.filmService = filmService;
    }

    @GetMapping("/medias")
    public String getAllMedias(Model model) {
        List<Media> medias = mediaService.getAllMedias();
        List<Film> films = filmService.getAllFilms();
        model.addAttribute("medias", medias);
        model.addAttribute("films", films);
        return "medias";
    }

    @PostMapping("/medias")
    public String createOrUpdateMedia(@ModelAttribute("media") Media media, @RequestParam("photos") List<MultipartFile> files) {
        try {
            List<String> filenames = new ArrayList<>();

            for (MultipartFile file : files) {
                String filename = file.getOriginalFilename();
                filenames.add(filename);

                byte[] bytes = file.getBytes();
                Path uploadPath = Paths.get("src/main/resources/static/media-img/" + filename);
                Files.createDirectories(uploadPath.getParent());
                Files.write(uploadPath, bytes);
            }

            media.setPhotoList(filenames);

            Optional<Media> existingMedia = mediaService.getMediaById(media.getId());
            if (existingMedia.isPresent()) {
                Media existing = existingMedia.get();
                existing.setVideo(media.getVideo());
                existing.setPhotoList(media.getPhotoList());
                mediaService.createOrUpdateMedia(existing);
            } else {
                media.setAdded_date(new Timestamp(System.currentTimeMillis()));
                mediaService.createOrUpdateMedia(media);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/medias";
    }


    @PostMapping("/medias/{id}")
    public String deleteArtist(@PathVariable int id) {
        mediaService.deleteMediaById(id);
        return "redirect:/medias";
    }
}

