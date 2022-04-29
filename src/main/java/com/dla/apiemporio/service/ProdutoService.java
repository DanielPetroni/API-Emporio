package com.dla.apiemporio.service;

import java.util.List;

import com.dla.apiemporio.dto.DTOProduto;
import com.dla.apiemporio.entity.Produto;
import com.dla.apiemporio.repository.ProdutoRepository;
import com.dla.apiemporio.shared.CloudinaryShared.CloudinaryShared;

import org.springframework.beans.factory.annotation.Autowired;

public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CloudinaryShared cloudinaryShared;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.getById(id);
    }

    public Produto save(DTOProduto dtoProduto) throws Exception {

        Produto produto = new Produto();
        produto.setFromObject(dtoProduto);
        List<Produto> produtos = findByGtin(produto.getGtinProduto());
        System.out.println();
        if (produtos.size() > 0) {
            throw new Exception("Produto já cadastrado!");
        }
        String urlImageProduto = cloudinaryShared.uploadFile("product", dtoProduto.getImageProdutos().getBytes());
        produto.seturlImagemProduto(urlImageProduto);
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

    public Produto update(Long id, DTOProduto dtoProduto) throws Exception {
        Produto produto = new Produto();
        produto.setFromObject(dtoProduto);
        Produto produtoFinded = produtoRepository.getById(id);
        if (produtoFinded != null) {
            produtoFinded.setFromObject(produto);
            produtoRepository.save(produtoFinded);
            return produto;
        } else {
            throw new Exception("Produto não encontrado!");
        }

    }

    private List<Produto> findByGtin(Long id) {
        return produtoRepository.findByGtinProduto(id);
    }

}
