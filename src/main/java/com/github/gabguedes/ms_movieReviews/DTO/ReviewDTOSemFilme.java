package com.github.gabguedes.ms_movieReviews.DTO;

import com.github.gabguedes.ms_movieReviews.model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewDTOSemFilme {

    private Long id;

    private String texto;

    private UserDTO user;

    private Long filmeId;


    public ReviewDTOSemFilme(Review entity) {
        this.id = entity.getId();
        this.texto = entity.getTexto();
        this.user = new UserDTO(entity.getUser());
        this.filmeId = entity.getFilme().getId();
    }

}
