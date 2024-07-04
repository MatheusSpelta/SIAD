package com.example.SIAD.Dominio.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VendaDTO {
    private Long id;
    private Double total;
    private Double quantidade;
    private Long fisicaId;
    private String Fisica_nome;
    private Long produtoId;
    private String produtoNome;
    private Double produtoValor;
}
