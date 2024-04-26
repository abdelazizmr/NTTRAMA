package com.ntt.cinema.models;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Timestamp added_date;
    private int year;
    private int duration;
    private String title;
    private String photo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director_id")
    private Artist director;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<Artist> actors;

    @OneToMany(mappedBy = "film")
    private List<Rating> ratings;

    private double averageRating;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL)
    private List<Media> mediaList;
    
   

    @ElementCollection
    @CollectionTable(
            name = "rating",
            joinColumns = @JoinColumn(name = "film_id")
    )
    @Column(name = "comment")
    private List<String> comments;

    public Film() {
    }

    public void updateAverageRating() {
        if (ratings == null || ratings.isEmpty()) {
            this.averageRating = 0.0;
            return;
        }
        int totalScore = 0;
        for (Rating rating : ratings) {
            totalScore += rating.getScore();
        }
        this.averageRating = ((double) totalScore / ratings.size());
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public Artist getDirector() {
        return director;
    }

    public void setDirector(Artist director) {
        this.director = director;
    }

    public List<Artist> getActors() {
        return actors;
    }

    public void setActors(List<Artist> actors) {
        this.actors = actors;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getAverageRating() {
        updateAverageRating();
        return averageRating;
    }

    public List<Media> getMediaList() {
        return mediaList;
    }

    public void setMediaList(List<Media> mediaList) {
        this.mediaList = mediaList;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }
}
