package com.github.gabguedes.ms_movieReviews.controller;

import com.github.gabguedes.ms_movieReviews.DTO.FilmeDTO;
import com.github.gabguedes.ms_movieReviews.service.FilmeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/filmes")
public class FilmeController {

    @Autowired
    FilmeService service;

    @GetMapping
    public ResponseEntity<List<FilmeDTO>> findAll(){
        List<FilmeDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeDTO> findById(@PathVariable Long id){
        FilmeDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<FilmeDTO> insert(@RequestBody @Valid FilmeDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto)
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeDTO> update(@PathVariable Long id,
                                           @RequestBody @Valid FilmeDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FilmeDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}