package com.github.gabguedes.ms_movieReviews.DTO;

import com.github.gabguedes.ms_movieReviews.model.Filme;
import com.github.gabguedes.ms_movieReviews.model.Genero;
import com.github.gabguedes.ms_movieReviews.model.Review;
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
public class FilmeDTO {

    private Long id;

    private String titulo;

    private Integer ano;

    private List<ReviewDTOSemFilme> reviews = new ArrayList<>();

    private GeneroDTO genero;

    public FilmeDTO(Filme entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.ano = entity.getAno();
        this.genero = new GeneroDTO(entity.getGenero());
//        this.reviews = entity.getReviews().stream().map(ReviewDTO::new).toList();
        entity.getReviews().forEach(review -> reviews.add(new ReviewDTOSemFilme(review)));
    }
}
