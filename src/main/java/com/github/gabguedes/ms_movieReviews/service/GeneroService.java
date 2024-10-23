package com.github.gabguedes.ms_movieReviews.service;

import com.github.gabguedes.ms_movieReviews.DTO.GeneroDTO;
import com.github.gabguedes.ms_movieReviews.model.Genero;
import com.github.gabguedes.ms_movieReviews.repository.GeneroRepository;
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
public class GeneroService {
    
    @Autowired
    private GeneroRepository repository;

    @Transactional(readOnly = true)
    public List<GeneroDTO> findAll(){
        return repository.findAll().stream().map(GeneroDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GeneroDTO findById(Long id){
        Genero genero = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado: " + id)
        );
        return new GeneroDTO(genero);
    }

    @Transactional
    public GeneroDTO insert(GeneroDTO dto){
        Genero genero = new Genero();
        copyDtoToEntity(dto, genero);
        genero = repository.save(genero);
        return new GeneroDTO(genero);
    }

    @Transactional
    public GeneroDTO update(Long id, GeneroDTO dto){
        try {
            Genero genero = repository.getReferenceById(id);
            copyDtoToEntity(dto, genero);
            genero = repository.save(genero);
            return new GeneroDTO(genero);
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

    private void copyDtoToEntity(GeneroDTO dto, Genero genero) {
        genero.setNome(dto.getNome());
    }
}
