package com.dla.apiemporio.service;

import java.util.List;

import com.dla.apiemporio.model.Produto;
import com.dla.apiemporio.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.getById(id);
    }

    public Produto save(Produto produto) throws Exception {
        List<Produto> produtos = findByGtin(produto.getGtinProduto());
        if (produtos.size() > 0) {
            throw new Exception("Produto já cadastrado!");
        }
        produtoRepository.save(produto);
        return produto;
    }

    public void delete(Long id) throws Exception {
        Produto produto = produtoRepository.getById(id);
        if (produto != null) {
            produtoRepository.deleteById(id);
        } else {
            throw new Exception("Produto não encontrado!");
        }

    }

    public void update(Long id, Produto produto) throws Exception {
        Produto produtoFinded = produtoRepository.getById(id);
        if (produtoFinded != null) {
            produtoFinded.setFromObject(produto);
            produtoRepository.save(produtoFinded);
        } else {
            throw new Exception("Produto não encontrado!");
        }

    }

    private List<Produto> findByGtin(Long id) {
        return produtoRepository.findByGtinProduto(id);
    }

}
