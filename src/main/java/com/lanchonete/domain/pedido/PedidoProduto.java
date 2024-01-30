package com.lanchonete.domain.pedido;

import com.lanchonete.domain.cardapio.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "pedido_produto")
@Getter
@Setter
@NoArgsConstructor
public class PedidoProduto {

    @ManyToOne
    @JoinColumn(name = "id")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "id")
    private Produto produto;
}
