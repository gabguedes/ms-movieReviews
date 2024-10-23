package com.github.gabguedes.ms_movieReviews.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomErrorDTO {
    private String timestamp;
    private Integer status;
    private String error;
    private String path;
}
