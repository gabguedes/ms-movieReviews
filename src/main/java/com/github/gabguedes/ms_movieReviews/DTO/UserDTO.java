package com.github.gabguedes.ms_movieReviews.DTO;

import com.github.gabguedes.ms_movieReviews.model.Review;
import com.github.gabguedes.ms_movieReviews.model.User;
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
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String password;

    private List<ReviewDTO> reviews = new ArrayList<>();

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.password = entity.getPassword();
//        this.reviews = entity.getReviews().stream().map(ReviewDTO::new).toList();
        entity.getReviews().forEach(review -> reviews.add(new ReviewDTO(review)));
    }
}
