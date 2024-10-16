package com.github.gabguedes.ms_movieReviews.model;


import jakarta.persistence.*;
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
@Entity
@Table(name = "tb_filme")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private Integer ano;

    @OneToMany(mappedBy = "filme", fetch = FetchType.EAGER)
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "genero_id")
    private Genero genero;

}
