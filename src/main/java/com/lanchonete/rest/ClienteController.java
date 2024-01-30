package com.lanchonete.rest;

import com.lanchonete.domain.cliente.Cliente;
import com.lanchonete.dto.ClienteRequest;
import com.lanchonete.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente(@RequestBody ClienteRequest request) {
        Cliente cliente = clienteService.saveCliente(request);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Cliente> getCPF(@PathVariable("cpf") String cpf) {
        Cliente cliente = clienteService.getClienteFromCPF(cpf);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }
}