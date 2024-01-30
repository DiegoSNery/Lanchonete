package com.lanchonete.domain.pedido;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cliente;
    private double preco;
    @OneToMany
    @JoinColumn(name = "pedido")
    private List<PedidoProduto> pedidoProdutos;
}
