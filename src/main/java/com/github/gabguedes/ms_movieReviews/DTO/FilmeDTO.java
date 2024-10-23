package com.github.gabguedes.ms_movieReviews.DTO;

import com.github.gabguedes.ms_movieReviews.model.Filme;
import com.github.gabguedes.ms_movieReviews.model.Genero;
import com.github.gabguedes.ms_movieReviews.model.Review;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotBlank(message = "Titulo é obrigatório.")
    private String titulo;

    @NotNull(message = "Ano é obrigatório.")
    @Positive
    private Integer ano;

    private List<ReviewDTO> reviews = new ArrayList<>();

    private Long generoId;

    public FilmeDTO(Filme entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.ano = entity.getAno();
        this.generoId = entity.getGenero().getId();
//        this.reviews = entity.getReviews().stream().map(ReviewDTO::new).toList();
        entity.getReviews().forEach(review -> reviews.add(new ReviewDTO(review)));
    }
}
