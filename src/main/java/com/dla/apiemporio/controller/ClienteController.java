package com.dla.apiemporio.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.dla.apiemporio.entity.Cliente;
import com.dla.apiemporio.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired

    ClienteService clienteService;

    @GetMapping("/")
    public List<Cliente> findAll() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Long id) {
        try {
            return clienteService.findById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/")
    public void create(@RequestBody Cliente cliente, HttpServletResponse response) {
        if (cliente.getNomeCliente() == null || cliente.getCpfCliente() == null
                || cliente.getEnderecoCliente() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        try {
            clienteService.save(cliente);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> create(@RequestBody Cliente cliente, @PathVariable("id") Long id,
            HttpServletResponse response) {
        if (cliente.getNomeCliente() == null || cliente.getCpfCliente() == null
                || cliente.getEnderecoCliente() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }
        try {
            clienteService.update(id, cliente);
            HashMap<String, String> bodyResponse = new HashMap<String, String>();
            bodyResponse.put("message", "Cliente atualizado!");
            return new ResponseEntity<Object>(bodyResponse, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        try {
            clienteService.delete(id);
            HashMap<String, String> bodyResponse = new HashMap<String, String>();
            bodyResponse.put("message", "Cliente deletado!");
            return new ResponseEntity<Object>(bodyResponse, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
