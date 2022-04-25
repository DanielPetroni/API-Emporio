package com.dla.apiemporio.controller;

import com.dla.apiemporio.entity.Produto;
import com.dla.apiemporio.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
    public Produto update(@RequestBody(required = false) Produto produto, @PathVariable("id") Long id,
            HttpServletResponse response) {
        if (produto == null || !Produto.isValid(produto)) {
            System.out.println("ENTROU AQUi");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválido!");
        }
        try {
            produtoService.update(id, produto);
            return produto;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        try {
            produtoService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
