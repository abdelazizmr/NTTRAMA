// ArtistController.java
package com.ntt.cinema.controllers;

import com.ntt.cinema.models.Artist;
import com.ntt.cinema.models.Nationality;
import com.ntt.cinema.services.ArtistService;
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
import java.util.List;
import java.util.Optional;

@Controller
public class ArtistController {

    private final ArtistService artistService;
//    private final ArtistTypeService artistTypeService;
    private final NationalityService nationalityService;

    @Autowired
    public ArtistController(ArtistService artistService, NationalityService nationalityService) {
        this.artistService = artistService;
        this.nationalityService = nationalityService;
    }

    @GetMapping("/artists")
    public String getAllArtists(Model model) {
        List<Artist> artists = artistService.getAllArtists();
        List<Nationality> nationalities = nationalityService.getAllNationalities();
        model.addAttribute("artists", artists);
        model.addAttribute("nationalities", nationalities);
        return "artists";
    }

//    @PostMapping("/artists")
//    public String createOrUpdateArtist(@ModelAttribute("artist") Artist artist) {
//        Optional<Artist> existingArtist = artistService.getArtistById(artist.getId());
//        if (existingArtist.isPresent()) {
//            Artist existing = existingArtist.get();
//            existing.setFirstName(artist.getFirstName());
//            existing.setLastName(artist.getLastName());
//            existing.setPhoto(artist.getPhoto());
//            existing.setArtistType(artist.getArtistType());
//            artistService.createOrUpdateArtist(existing);
//        } else {
//            artist.setAdded_date(new Timestamp(System.currentTimeMillis()));
//            artistService.createOrUpdateArtist(artist);
//        }
//        return "redirect:/artists";
//    }

    @PostMapping("/artists")
    public String createOrUpdateArtist(@ModelAttribute("artist") Artist artist, @RequestParam("image") MultipartFile file) {
        try {
            artist.setPhoto(file.getOriginalFilename());
            byte[] bytes = file.getBytes();
            Path uploadPath = Paths.get("src/main/resources/static/artist-img/" + file.getOriginalFilename());
            Files.createDirectories(uploadPath.getParent());
            Files.write(uploadPath, bytes);
            Optional<Artist> existingArtist = artistService.getArtistById(artist.getId());
            if (existingArtist.isPresent()) {
                Artist existing = existingArtist.get();
                existing.setFirstName(artist.getFirstName());
                existing.setLastName(artist.getLastName());
                existing.setPhoto(artist.getPhoto());
                existing.setArtistType(artist.getArtistType());
                artistService.createOrUpdateArtist(existing);
            } else {
                artist.setAdded_date(new Timestamp(System.currentTimeMillis()));
                artistService.createOrUpdateArtist(artist);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/artists";
    }

//    @PostMapping("/artists")
//    public String createOrUpdateArtist(@ModelAttribute("artist") Artist artist,
//                                       @RequestParam("photo") MultipartFile file) {
//        try {
//            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//            Path uploadPath = Paths.get("static/artist-img/");
//            if (!Files.exists(uploadPath)) {
//                Files.createDirectories(uploadPath);
//            }
//            try (InputStream inputStream = file.getInputStream()) {
//                Files.copy(inputStream, uploadPath.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
//            }
//            artist.setPhoto("/artist-img/" + fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Optional<Artist> existingArtist = artistService.getArtistById(artist.getId());
//        if (existingArtist.isPresent()) {
//            Artist existing = existingArtist.get();
//            existing.setFirstName(artist.getFirstName());
//            existing.setLastName(artist.getLastName());
//            // Set other artist fields
//            artistService.createOrUpdateArtist(existing);
//        } else {
//            artist.setAdded_date(new Timestamp(System.currentTimeMillis()));
//            // Set other artist fields
//            artistService.createOrUpdateArtist(artist);
//        }
//        return "redirect:/artists";
//    }


    @PostMapping("/artists/{id}")
    public String deleteArtist(@PathVariable int id) {
        artistService.deleteArtistById(id);
        return "redirect:/artists";
    }
}
