package com.dla.apiemporio.service;

import java.util.List;
import java.util.Optional;

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

    public Produto findById(Long id) throws Exception {
        Optional<Produto> optionalProdutoFinded = produtoRepository.findById(id);
        if (!optionalProdutoFinded.isPresent()) {
            throw new Exception("Produto não encontrado!");
        }
        return optionalProdutoFinded.get();

    }

    public Produto save(DTOProduto dtoProduto) throws Exception {
        try {
            Produto produto = new Produto();
            produto.setFromObject(dtoProduto);
            
            List<Produto> produtos = findByGtin(produto.getGtinProduto());
            if (produtos.size() > 0) {
                throw new Exception("Produto já cadastrado!");
            }
            if (dtoProduto.getImageProduto()!=null && !dtoProduto.getImageProduto().isEmpty()) {
                try {
                    String urlImageProduto = cloudinaryShared.uploadFile("product",
                            dtoProduto.getImageProduto().getBytes());
                    produto.seturlImagemProduto(urlImageProduto);
                } catch (Exception error) {
                    throw new Exception(error);
                }

            }
            produtoRepository.save(produto);
            return produto;
        } catch (Exception error) {
            throw new Exception(error);
        }
    }

    public void delete(Long id) throws Exception {
        Optional<Produto> optionalProdutoFinded = produtoRepository.findById(id);
        if (!optionalProdutoFinded.isPresent()) {
            throw new Exception("Produto não encontrado!");
        }
        produtoRepository.delete(optionalProdutoFinded.get());
    }

    public Produto update(Long id, DTOProduto dtoProduto) throws Exception {
        Optional<Produto> optionalProdutoFinded = produtoRepository.findById(id);
        if (!optionalProdutoFinded.isPresent()) {
            throw new Exception("Produto não encontrado!");
        }
        Produto produtoFinded = optionalProdutoFinded.get();
        produtoFinded.setFromObject(dtoProduto);
        if (dtoProduto.getImageProduto() != null &&
                !dtoProduto.getImageProduto().isEmpty()) {
            String urlImageProduto = cloudinaryShared.uploadFile("product",
                    dtoProduto.getImageProduto().getBytes());
            produtoFinded.seturlImagemProduto(urlImageProduto);
        }
        if (dtoProduto.getImageProduto().isEmpty()) {
            produtoFinded.seturlImagemProduto(null);
        }
        produtoRepository.save(produtoFinded);
        return produtoFinded;

    }

    private List<Produto> findByGtin(Long id) {
        return produtoRepository.findByGtinProduto(id);
    }

}
