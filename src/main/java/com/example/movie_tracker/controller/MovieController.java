package com.example.movie_tracker.controller;


import com.example.movie_tracker.model.Movie;
import com.example.movie_tracker.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {

})

@RestController
@RequestMapping("/api/movies")


public class MovieController {
    @Autowired
    public MovieRepository movieRepository;

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieRepository.save(movie);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie updateMovie){
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if(optionalMovie.isPresent()){
            Movie movie = optionalMovie.get();
            movie.setTitle(updateMovie.getTitle());
            movie.setDirector(updateMovie.getDirector());
            movie.setReleaseYear(updateMovie.getReleaseYear());
            movie.setRating(updateMovie.getRating());
            movie.setWatched(updateMovie.isWatched());
            movie.setPoster(updateMovie.getPoster());
            movie.setDescription(updateMovie.getDescription());

            return movieRepository.save(movie);
        }else{
            throw new RuntimeException("Movie not found with ID " + id);
        }
    }

    @PutMapping("/{id}/toggleWatched")
    public ResponseEntity<?> toggleMovie(@PathVariable Long id){
        Movie movie = movieRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Movie not found"));
        if(movie.getTitle() == null || movie.getTitle().trim().isEmpty()){
            return ResponseEntity.badRequest().body("Movie title cannot be null or empty.");
        }
        movie.setWatched(!movie.isWatched());
        return ResponseEntity.ok(movieRepository.save(movie));
  }

  @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieRepository.deleteById(id);
  }
}
