package com.lanchonete.rest;

import com.lanchonete.domain.pedido.Pedido;
import com.lanchonete.dto.PedidoRequest;
import com.lanchonete.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
  private final PedidoService pedidoService;

  @Autowired
  public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
  }

    @PostMapping
    public ResponseEntity<Pedido> cadastrarPedido(@RequestBody PedidoRequest request) {
        Pedido pedido = pedidoService.savePedido(request);
        return new ResponseEntity<>(pedido, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List> getAll() {
        List<Pedido> pedidos = pedidoService.getAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }


}
