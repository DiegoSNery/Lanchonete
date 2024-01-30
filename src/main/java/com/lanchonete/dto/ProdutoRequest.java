package com.lanchonete.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoRequest {
    private Long id;
    private String nome;
    private double preco;
    private String categoria;
}
