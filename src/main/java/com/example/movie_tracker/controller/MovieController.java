package com.example.movie_tracker.controller;

import com.example.movie_tracker.model.Movie;
import com.example.movie_tracker.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://movie-tracker-front-end.vercel.app"
})
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // ✅ GET ALL
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // ✅ CREATE
    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // ✅ UPDATE (FULL UPDATE)
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie updateMovie) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with ID " + id));

        movie.setTitle(updateMovie.getTitle());
        movie.setDirector(updateMovie.getDirector());
        movie.setReleaseYear(updateMovie.getReleaseYear());
        movie.setRating(updateMovie.getRating());
        movie.setWatched(updateMovie.isWatched());
        movie.setToWatch(updateMovie.getToWatch());
        movie.setPoster(updateMovie.getPoster());
        movie.setDescription(updateMovie.getDescription());
        movie.setRuntime(updateMovie.getRuntime());
        movie.setBoxOffice(updateMovie.getBoxOffice());
        movie.setTrailerUrl(updateMovie.getTrailerUrl());

        return movieRepository.save(movie);
    }

    // ✅ TOGGLE WATCHED
    @PutMapping("/{id}/toggleWatched")
    public ResponseEntity<Movie> toggleWatched(@PathVariable Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        movie.setWatched(!movie.isWatched());
        return ResponseEntity.ok(movieRepository.save(movie));
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }

    // ✅ TEST ENDPOINT
    @GetMapping("/test")
    public String testEndpoint() {
        return "✅ Backend is working!";
    }
}
