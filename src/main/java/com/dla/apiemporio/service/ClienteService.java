package com.dla.apiemporio.service;

import java.util.List;

import com.dla.apiemporio.entity.Cliente;
import com.dla.apiemporio.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.getById(id);
    }

    public Cliente save(Cliente cliente) throws Exception {
        List<Cliente> clientes = clienteRepository.findBycpfCliente(cliente.getCpfCliente());
        if (clientes.size() > 0) {
            throw new Exception("Cliente já cadastrado!");
        }
        clienteRepository.save(cliente);
        return cliente;
    }

    public void update(Long id, Cliente cliente) throws Exception {
        Cliente clienteFinded = clienteRepository.getById(id);
        if (clienteFinded != null) {
            clienteFinded = cliente;
            clienteRepository.save(clienteFinded);
        } else {
            throw new Exception("Produto não encontrado!");
        }

    }

    public void delete(Long id) throws Exception {
        Cliente clienteFinded = clienteRepository.getById(id);
        if (clienteFinded != null) {
            clienteRepository.deleteById(id);
        } else {
            throw new Exception("Cliente não encontrado!");
        }

    }
}
