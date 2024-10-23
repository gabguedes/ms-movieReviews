package com.github.gabguedes.ms_movieReviews.DTO.errorDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FieldMessageDTO {

    private String fieldName;
    private String message;

}
