package com.github.gabguedes.ms_movieReviews.DTO;

import com.github.gabguedes.ms_movieReviews.model.Filme;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmeDTOInsert {
    private Long id;

    private String titulo;

    private Integer ano;

    private Long generoId;

    public FilmeDTOInsert(Filme entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.ano = entity.getAno();
        this.generoId = entity.getGenero().getId();
    }
}
