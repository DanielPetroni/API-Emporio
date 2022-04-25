package com.dla.apiemporio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {

    public Cliente() {
    }

    public Cliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Id
    @GeneratedValue
    private Long idCliente;

    private String nomeCliente;

    @Column(unique = true, nullable = false)
    private Long cpfCliente;

    private String emailCliente;

    private String telefoneCliente;

    @ManyToOne
    @JoinColumn(name = "idEndereco")
    private Endereco idEndereco;

    public Cliente(String nomeCliente, Long cpfCliente, String emailCliente, String telefoneCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;

    }

    public Long getIdCliente() {
        return idCliente;
    }
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

    public Endereco getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Endereco idEndereco) {
        this.idEndereco = idEndereco;
    }

}
