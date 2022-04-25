package com.dla.apiemporio.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.dla.apiemporio.model.Cliente;
import com.dla.apiemporio.model.Endereco;
import com.dla.apiemporio.service.ClienteService;
import com.dla.apiemporio.service.EnderecoService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public void create(@RequestBody String json, HttpServletResponse response) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode clienteJson = objectMapper.readTree(json);
            JsonNode enderecoJson = clienteJson.get("endereco");

            if (clienteJson.get("nomeCliente") == null || clienteJson.get("cpfCliente") == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
            }

            Cliente cliente = new Cliente(clienteJson.path("nomeCliente").asText(),
                    clienteJson.path("cpfCliente").asLong(), clienteJson.path("emailCliente").asText(),
                    clienteJson.path("telefoneCliente").asText());
            clienteService.save(cliente);

            Endereco endereco = new Endereco(enderecoJson.path("ruaEndereco").asText(),
                    enderecoJson.path("bairroEndereco").asText(), enderecoJson.path("cidadeEndereco").asText(),
                    enderecoJson.path("ufEndereco").asText());
            enderecoService.save(endereco);

            cliente.setIdEndereco(endereco);
            clienteService.update(cliente.getIdCliente(), cliente);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }
}
