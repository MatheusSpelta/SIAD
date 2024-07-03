package com.example.SIAD.Dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "venda")

public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "total")
    private Double total;

    @Column(name = "quantidade")
    private Double quantidade;

    @ManyToOne
    @JoinColumn(name = "fisica_id")
    private Fisica fisica;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
}
