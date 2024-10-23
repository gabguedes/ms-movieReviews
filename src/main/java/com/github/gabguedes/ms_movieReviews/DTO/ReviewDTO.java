package com.github.gabguedes.ms_movieReviews.DTO;

import com.github.gabguedes.ms_movieReviews.model.Filme;
import com.github.gabguedes.ms_movieReviews.model.Review;
import com.github.gabguedes.ms_movieReviews.model.User;
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

    private String texto;

    private UserDTO user;

    private FilmeDTOSemReviews filme;

    public ReviewDTO(Review entity) {
        this.id = entity.getId();
        this.texto = entity.getTexto();
        this.user = new UserDTO(entity.getUser());
        this.filme = new FilmeDTOSemReviews(entity.getFilme());
    }
}
