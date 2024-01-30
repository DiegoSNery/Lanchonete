package com.lanchonete.dto;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
public class PedidoRequest {

    private Long id;
    private Long cliente;
    private double preco;
    private List<Long> pedidoProdutos;
}
