package com.lanchonete.service;

import com.lanchonete.domain.cardapio.Produto;
import com.lanchonete.domain.pedido.Fila;
import com.lanchonete.domain.pedido.Pedido;
import com.lanchonete.domain.pedido.PedidoProduto;
import com.lanchonete.dto.PedidoRequest;
import com.lanchonete.repository.FilaRepository;
import com.lanchonete.repository.PedidoRepository;
import com.lanchonete.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final FilaRepository filaRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, FilaRepository filaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.filaRepository = filaRepository;
    }

    public Pedido savePedido(PedidoRequest pedidoRequest){
        Pedido pedido = new Pedido();
        pedido.setCliente(pedidoRequest.getCliente());
        pedido.setPreco(pedidoRequest.getPreco());
        pedido.setPedidoProdutos(new ArrayList<>());
        for(Long produtoId : pedidoRequest.getPedidoProdutos()) {
            PedidoProduto pedidoProduto = new PedidoProduto();
            pedidoProduto.setPedido(pedido);
            Optional<Produto> produto = produtoRepository.findById(produtoId);
            pedidoProduto.setProduto(produto.get());
            pedido.getPedidoProdutos().add(pedidoProduto);
        }
        pedidoRepository.save(pedido);
        Fila fila = new Fila();
        fila.setPedido(pedido);
        fila.setStatus("Recebido");
        filaRepository.save(fila);
        return pedido;
    }

    public List getAll(){
        return (List) filaRepository.findAll();
    }
}
