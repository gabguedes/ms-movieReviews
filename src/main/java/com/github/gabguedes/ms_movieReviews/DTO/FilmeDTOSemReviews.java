package com.github.gabguedes.ms_movieReviews.DTO;

import com.github.gabguedes.ms_movieReviews.model.Filme;
import com.github.gabguedes.ms_movieReviews.model.Genero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilmeDTOSemReviews {

    private Long id;

    private String titulo;

    private Integer ano;

    private Genero genero;

    public FilmeDTOSemReviews(Filme entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.ano = entity.getAno();
        this.genero = entity.getGenero();
    }
}
