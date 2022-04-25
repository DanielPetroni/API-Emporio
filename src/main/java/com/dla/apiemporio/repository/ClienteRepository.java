package com.dla.apiemporio.repository;

import java.util.List;

import com.dla.apiemporio.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findBycpfCliente(Long cpfCliente);
}
