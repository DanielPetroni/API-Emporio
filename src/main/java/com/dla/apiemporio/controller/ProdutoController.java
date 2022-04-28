package com.dla.apiemporio.controller;

import com.dla.apiemporio.entity.Produto;
import com.dla.apiemporio.service.ProdutoService;

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

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController()
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public List<Produto> findAll() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable("id") Long id) {
        return produtoService.findById(id);
    }

    @PostMapping("/")
    public Produto create(@RequestBody Produto produto, HttpServletResponse response) {
        if (produto == null || !Produto.isValid(produto)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto inválido!");
        }
        try {
            produtoService.save(produto);
            return produto;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody(required = false) Produto produto, @PathVariable("id") Long id,
            HttpServletResponse response) {
        if (produto == null || !Produto.isValid(produto)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválido!");
        }
        try {
            produtoService.update(id, produto);
            HashMap<String, String> bodyResponse = new HashMap<String, String>();
            bodyResponse.put("message", "Produto atualizado!");
            return new ResponseEntity<Object>(bodyResponse, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        try {
            produtoService.delete(id);
            HashMap<String, String> bodyResponse = new HashMap<String, String>();
            bodyResponse.put("message", "Produto deletado!");
            return new ResponseEntity<Object>(bodyResponse, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
