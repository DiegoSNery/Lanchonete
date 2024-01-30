package com.lanchonete.service;

import com.lanchonete.domain.cardapio.Produto;
import com.lanchonete.dto.ProdutoRequest;
import com.lanchonete.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto saveProduto(ProdutoRequest produtoRequest){
        Produto produto = new Produto();
        produto.setNome(produtoRequest.getNome());
        produto.setCategoria(produtoRequest.getCategoria());
        produto.setPreco(produtoRequest.getPreco());
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(ProdutoRequest produtoRequest){
        Optional<Produto> produto = produtoRepository.findById(produtoRequest.getId());
        if(produto.isPresent()) {
            produto.get().setNome(produtoRequest.getNome());
            produto.get().setCategoria(produtoRequest.getCategoria());
            produto.get().setPreco(produtoRequest.getPreco());
            return produtoRepository.save(produto.get());
        }
        return null;
    }

    public void deleteProduto(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto getProdutosFromCategoria(String categoria){
        return produtoRepository.findByCategoria(categoria);
    }
}
