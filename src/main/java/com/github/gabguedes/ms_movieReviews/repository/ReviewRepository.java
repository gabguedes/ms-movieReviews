package com.github.gabguedes.ms_movieReviews.repository;

import com.github.gabguedes.ms_movieReviews.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
}
