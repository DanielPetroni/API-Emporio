package com.dla.apiemporio.service;

import java.util.List;

import com.dla.apiemporio.entity.Endereco;
import com.dla.apiemporio.repository.EnderecoRespository;

import org.springframework.beans.factory.annotation.Autowired;

public class EnderecoService {
    @Autowired
    private EnderecoRespository enderecoRespository;

    public List<Endereco> findAll() {
        return enderecoRespository.findAll();
    }

    public Endereco findById(Long id) {
        return enderecoRespository.getById(id);
    }

    public Endereco save(Endereco endereco) throws Exception {
        enderecoRespository.save(endereco);
        return endereco;
    }

    public void update(Long id, Endereco endereco) throws Exception {
        Endereco enderecoFinded = enderecoRespository.getById(id);
        if (enderecoFinded != null) {
            enderecoFinded = endereco;
            enderecoRespository.save(enderecoFinded);
        } else {
            throw new Exception("Endereço não encontrado!");
        }

    }

    public void delete(Long id) throws Exception {
        Endereco enderecoFinded = enderecoRespository.getById(id);
        if (enderecoFinded != null) {
            enderecoRespository.deleteById(id);
        } else {
            throw new Exception("Produto não encontrado!");
        }

    }

}
