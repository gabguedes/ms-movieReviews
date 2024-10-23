package com.github.gabguedes.ms_movieReviews.DTO;

import com.github.gabguedes.ms_movieReviews.model.Filme;
import com.github.gabguedes.ms_movieReviews.model.Review;
import com.github.gabguedes.ms_movieReviews.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewDTO {

    private Long id;

    @NotBlank(message = "Texto é obrigatório.")
    private String texto;

    private Long userId;

    private Long filmeId;

    public ReviewDTO(Review entity) {
        this.id = entity.getId();
        this.texto = entity.getTexto();
        this.userId = entity.getUser().getId();
        this.filmeId = entity.getFilme().getId();
    }
}
