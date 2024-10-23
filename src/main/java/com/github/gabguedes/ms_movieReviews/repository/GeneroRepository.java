package com.github.gabguedes.ms_movieReviews.repository;

import com.github.gabguedes.ms_movieReviews.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
