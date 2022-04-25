package com.dla.apiemporio.dto;

import com.dla.apiemporio.entity.Cliente;
import com.dla.apiemporio.entity.Endereco;

public class DTOCliente extends Cliente {
    public DTOCliente() {
    }

    private String nomeCliente;

    private Long cpfCliente;

    private String emailCliente;

    private String telefoneCliente;

    private Endereco enderecoCliente;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Long getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(Long cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public Endereco getEndereco() {
        return enderecoCliente;
    }

    public void setEnderecoCliente(Endereco endereco) {
        this.enderecoCliente = endereco;
    }

    public Cliente toClienteEntity() {
        Cliente clienteEntity = new Cliente();
        clienteEntity.setNomeCliente(this.nomeCliente);
        clienteEntity.setEmailCliente(this.emailCliente);
        clienteEntity.setCpfCliente(this.cpfCliente);
        clienteEntity.setTelefoneCliente(this.telefoneCliente);
        return clienteEntity;
    }
}
