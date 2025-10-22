package com.gabijava.cadastro_livro.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="title", unique = true)
    private String title;

    @Column(name="autor", length = 30)
    private String autor;

    @Column(name="published")
    private String published;
}
