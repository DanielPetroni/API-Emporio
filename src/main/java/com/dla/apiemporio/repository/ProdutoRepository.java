package com.dla.apiemporio.repository;

import java.util.List;

import com.dla.apiemporio.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByGtinProduto(long gtinProduto);

}
