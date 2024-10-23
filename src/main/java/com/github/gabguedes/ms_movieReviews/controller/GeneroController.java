package com.github.gabguedes.ms_movieReviews.controller;

import com.github.gabguedes.ms_movieReviews.DTO.GeneroDTO;
import com.github.gabguedes.ms_movieReviews.service.GeneroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/generos")
public class GeneroController {
    @Autowired
    GeneroService service;

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> findAll(){
        List<GeneroDTO> dto = service.findAll();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO> findById(@PathVariable Long id){
        GeneroDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<GeneroDTO> insert(@RequestBody @Valid GeneroDTO dto){
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto)
                .toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroDTO> update(@PathVariable Long id,
                                           @RequestBody @Valid GeneroDTO dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GeneroDTO> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
