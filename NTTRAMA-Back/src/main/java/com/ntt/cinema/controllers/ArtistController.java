//package com.ntt.cinema.controllers;
//
//import com.ntt.cinema.models.Artist;
//import com.ntt.cinema.services.ArtistService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/artists")
//public class ArtistController {
//
//    private final ArtistService artistService;
//
//    @Autowired
//    public ArtistController(ArtistService artistService) {
//        this.artistService = artistService;
//    }
//
//    @GetMapping
//    public String getAllArtists(Model model) {
//        List<Artist> artists = artistService.getAllArtists();
//        model.addAttribute("artists", artists);
//        return "artists"; // Assuming you have a Thymeleaf template named "artists.html"
//    }
//
//    @GetMapping("/{id}")
//    public String getArtistById(@PathVariable int id, Model model) {
//        Optional<Artist> artist = artistService.getArtistById(id);
//        artist.ifPresent(value -> model.addAttribute("artist", value));
//        return artist.isPresent() ? "artist" : "artistNotFound"; // Assuming you have a Thymeleaf template named "artist.html" for existing artists and "artistNotFound.html" for non-existing artists
//    }
//
//    @GetMapping("/add")
//    public String showAddArtistForm(Model model) {
//        model.addAttribute("artist", new Artist());
//        return "addArtist"; // Assuming you have a Thymeleaf template for adding an artist named "addArtist.html"
//    }
//
//    @PostMapping("/add")
//    public String addArtist(@ModelAttribute("artist") Artist artist) {
//        artistService.createOrUpdateArtist(artist);
//        return "redirect:/artists";
//    }
//
//    @GetMapping("/{id}/edit")
//    public String showEditArtistForm(@PathVariable int id, Model model) {
//        Optional<Artist> artist = artistService.getArtistById(id);
//        artist.ifPresent(value -> model.addAttribute("artist", value));
//        return artist.isPresent() ? "editArtist" : "artistNotFound"; // Assuming you have a Thymeleaf template named "editArtist.html" for existing artists and "artistNotFound.html" for non-existing artists
//    }
//
//    @PostMapping("/{id}/edit")
//    public String editArtist(@PathVariable int id, @ModelAttribute("artist") Artist artist) {
//        artist.setId(id);
//        artistService.createOrUpdateArtist(artist);
//        return "redirect:/artists";
//    }
//
//    @PostMapping("/{id}/delete")
//    public String deleteArtist(@PathVariable int id) {
//        artistService.deleteArtistById(id);
//        return "redirect:/artists";
//    }
//}
//
