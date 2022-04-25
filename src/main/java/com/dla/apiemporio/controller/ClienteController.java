package com.dla.apiemporio.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dla.apiemporio.entity.Cliente;
import com.dla.apiemporio.entity.Endereco;
import com.dla.apiemporio.service.ClienteService;
import com.dla.apiemporio.service.EnderecoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired

    ClienteService clienteService;
    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/")
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Long id) {
        return clienteService.findById(id);
    }

    @PostMapping("/")
    public void create(@RequestBody Cliente cliente, HttpServletResponse response) {
        if (cliente.getNomeCliente() == null || cliente.getCpfCliente() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        try {
            Endereco endereco = enderecoService.save(cliente.getEnderecoCliente());
            cliente.setEnderecoCliente(endereco);
            clienteService.save(cliente);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
