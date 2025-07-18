package com.example.movie_tracker.model;

import jakarta.persistence.*;

@Entity

public class Movie {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer rating;
    private boolean watched;
    private String director;
    private Integer releaseYear;
    private String poster;
    @Lob
    @Column(length = 2000)
    private String description;

    private String runtime;
    private String boxOffice;
    @Column(name = "trailer_url")
    private String trailerUrl; //Optional - you'll set this manually or fetch elsewhere

    private boolean toWatch;

    public Movie() {
    }

    //constructor
    public Movie(String title, int rating, boolean watched, String director, int releaseYear, String poster, String description, String runtime, String boxOffice, String trailerUrl) {
        this.title = title;
        this.rating = rating;
        this.watched = watched;
        this.director = director;
        this.releaseYear = releaseYear;
        this.poster = poster;
        this.description = description;
        this.runtime = runtime;
        this.boxOffice = boxOffice;
        this.trailerUrl = trailerUrl;
        this.toWatch = toWatch;

    }

    // Getters and Setters
    //Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getRating() {
        return rating;
    }

    public boolean isWatched() {
        return watched;
    }

    public String getDirector() {
        return director;
    }

    public String getDescription() {
        return description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public String getPoster() {
        return poster;
    }

    public String getRuntime() {
        return runtime;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public boolean getToWatch(){
        return toWatch;
    }

    //Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setBoxOffice(String boxOffice){
        this.boxOffice = boxOffice;
    }

    public void setTrailerUrl(String trailerUrl){
        this.trailerUrl = trailerUrl;
    }

    public void setToWatch(boolean toWatch){
        this.toWatch = toWatch;
    }

}




