package com.example.SIAD.Dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "juridica_id")
    private Juridica juridica;
}
