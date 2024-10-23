package com.github.gabguedes.ms_movieReviews.service;

import com.github.gabguedes.ms_movieReviews.DTO.ReviewDTO;
import com.github.gabguedes.ms_movieReviews.model.Review;
import com.github.gabguedes.ms_movieReviews.repository.FilmeRepository;
import com.github.gabguedes.ms_movieReviews.repository.ReviewRepository;
import com.github.gabguedes.ms_movieReviews.repository.UserRepository;
import com.github.gabguedes.ms_movieReviews.service.exception.DatabaseException;
import com.github.gabguedes.ms_movieReviews.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    
    @Autowired
    private ReviewRepository repository;

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<ReviewDTO> findAll(){
        return repository.findAll().stream().map(ReviewDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ReviewDTO findById(Long id){
        Review review = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado: " + id)
        );
        return new ReviewDTO(review);
    }

    @Transactional
    public ReviewDTO insert(ReviewDTO dto){
        Review review = new Review();
        copyDtoToEntity(dto, review);
        review = repository.save(review);
        return new ReviewDTO(review);
    }

    @Transactional
    public ReviewDTO update(Long id, ReviewDTO dto){
        try {
            Review review = repository.getReferenceById(id);
            copyDtoToEntity(dto, review);
            review = repository.save(review);
            return new ReviewDTO(review);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado: " + id);
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encotrado: " + id);
        }
        try {
            repository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new DatabaseException("Falha na integridade referencial.");
        }
    }

    private void copyDtoToEntity(ReviewDTO dto, Review review) {
        review.setTexto(dto.getTexto());
        review.setFilme(filmeRepository.findById(dto.getFilmeId()).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encotrado: " + dto.getFilmeId())
        ));
        review.setUser(userRepository.findById(dto.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encotrado: " + dto.getUserId())
        ));
    }
    
}
