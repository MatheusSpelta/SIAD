package com.example.SIAD.Dominio;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id")
public class Juridica extends Pessoa {
    @Column(name = "cnpj")
    private String cnpj;
}
