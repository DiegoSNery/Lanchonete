package com.lanchonete.service;

import com.lanchonete.domain.cliente.Cliente;
import com.lanchonete.dto.ClienteRequest;
import com.lanchonete.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente saveCliente(ClienteRequest clienteRequest){
        Cliente cliente = new Cliente();
        cliente.setCpf(clienteRequest.getCpf());
        cliente.setNome(clienteRequest.getNome());
        cliente.setEmail(clienteRequest.getEmail());
        return clienteRepository.save(cliente);
    }

    public Cliente getClienteFromCPF(String cpf){
        return clienteRepository.findByCpf(cpf);
    }
}
