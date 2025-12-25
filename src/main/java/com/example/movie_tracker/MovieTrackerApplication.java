package com.example.movie_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.movie_tracker")
public class MovieTrackerApplication {
	public static void main(String[] args) {
		SpringApplication.run(MovieTrackerApplication.class, args);
	}
}

