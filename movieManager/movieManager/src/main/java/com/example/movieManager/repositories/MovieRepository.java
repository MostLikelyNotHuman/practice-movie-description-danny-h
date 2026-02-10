package com.example.movieManager.repositories;

import com.example.movieManager.classes.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
