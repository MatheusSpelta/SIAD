package com.example.SIAD.Dominio;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cep")
    private String cep;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "rua")
    // endereço
    private String rua;

    @Column(name = "numero")
    private String numero;

    @OneToMany(mappedBy = "endereco")
    private List<Fisica> pessoas;
}
