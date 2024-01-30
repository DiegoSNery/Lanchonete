package com.lanchonete.rest;

import com.lanchonete.domain.cardapio.Produto;
import com.lanchonete.domain.cliente.Cliente;
import com.lanchonete.dto.ProdutoRequest;
import com.lanchonete.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody ProdutoRequest request) {
        Produto produto = produtoService.saveProduto(request);
        return new ResponseEntity<>(produto, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Produto> editarProduto(@RequestBody ProdutoRequest request) {
        Produto produto = produtoService.updateProduto(request);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> removerProduto(@Param("id") Long id) {
        produtoService.deleteProduto(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Produto> getCategoria(@PathVariable("categoria") String categoria) {
        Produto produto = produtoService.getProdutosFromCategoria(categoria);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
}
