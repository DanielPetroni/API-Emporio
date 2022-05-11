package com.dla.apiemporio.service;

import java.util.List;
import java.util.Optional;

import com.dla.apiemporio.entity.Cliente;
import com.dla.apiemporio.entity.Endereco;
import com.dla.apiemporio.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoService enderecoService;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) throws Exception {
        Optional<Cliente> clienteFinded = clienteRepository.findById(id);
        if (clienteFinded.isPresent()) {
            return clienteFinded.get();
        } else {
            throw new Exception("Cliente não encontrado!");
        }

    }

    public Cliente save(Cliente cliente) throws Exception {
        List<Cliente> clientes = clienteRepository.findBycpfCliente(cliente.getCpfCliente());
        if (clientes.size() > 0) {
            throw new Exception("Cliente já cadastrado!");
        }
        Endereco endereco = enderecoService.save(cliente.getEnderecoCliente());
        cliente.setEnderecoCliente(endereco);
        clienteRepository.save(cliente);
        return cliente;

    }

    public void update(Long id, Cliente cliente) throws Exception {
        Optional<Cliente> optionalClient = clienteRepository.findById(id);
        if (optionalClient.isPresent()) {
            Cliente clienteFinded = optionalClient.get();
            clienteFinded.setFromObject(cliente);;
            clienteRepository.save(clienteFinded);
        } else {
            throw new Exception("Cliente não encontrado!");
        }

    }

    public void delete(Long id) throws Exception {
        Optional<Cliente> optionalClient = clienteRepository.findById(id);
        if (optionalClient.isPresent()) {
            Cliente clienteFinded = optionalClient.get();
            clienteRepository.deleteById(clienteFinded.getIdCliente());
        } else {
            throw new Exception("Cliente não encontrado!");
        }

    }
}
