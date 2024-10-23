package com.github.gabguedes.ms_movieReviews.DTO;

import com.github.gabguedes.ms_movieReviews.model.Filme;
import com.github.gabguedes.ms_movieReviews.model.Genero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GeneroDTO {

    private Long id;

    private String nome;

    private List<FilmeDTO> filmes = new ArrayList<>();

    public GeneroDTO(Genero entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        entity.getFilmes().forEach(filme -> filmes.add(new FilmeDTO(filme)));
    }
}
