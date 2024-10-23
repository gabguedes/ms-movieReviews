package com.github.gabguedes.ms_movieReviews.service;

import com.github.gabguedes.ms_movieReviews.DTO.FilmeDTO;
import com.github.gabguedes.ms_movieReviews.DTO.FilmeDTOInsert;
import com.github.gabguedes.ms_movieReviews.DTO.GeneroDTO;
import com.github.gabguedes.ms_movieReviews.model.Filme;
import com.github.gabguedes.ms_movieReviews.model.Genero;
import com.github.gabguedes.ms_movieReviews.repository.FilmeRepository;
import com.github.gabguedes.ms_movieReviews.repository.GeneroRepository;
import com.github.gabguedes.ms_movieReviews.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository repository;

    @Autowired private GeneroRepository generoRepository;

    @Transactional(readOnly = true)
    public List<FilmeDTO> findAll(){
        return repository.findAll().stream().map(FilmeDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FilmeDTO findById(Long id){
        Filme filme = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Recurso não encontrado: " + id)
        );
        return new FilmeDTO(filme);
    }

    @Transactional
    public FilmeDTO insert(FilmeDTOInsert dto){
        Filme filme = new Filme();
        copyDtoToEntity(dto, filme);
        filme = repository.save(filme);
        return new FilmeDTO(filme);
    }

    @Transactional
    public FilmeDTO update(FilmeDTO dto){
        Filme filme = repository.getReferenceById(dto.getId());
    }

    private void copyDtoToEntity(FilmeDTOInsert dto, Filme filme) {
        filme.setTitulo(dto.getTitulo());
        filme.setAno(dto.getAno());
        filme.setGenero(generoRepository.findById(dto.getGeneroId()).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado" + dto.getGeneroId())
        ));
    }


}
