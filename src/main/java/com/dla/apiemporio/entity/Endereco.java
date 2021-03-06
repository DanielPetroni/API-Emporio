package com.dla.apiemporio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
    public Endereco() {
    }

    public Endereco(String ruaEndereco, String bairroEndereco, String cidadeEndereco, String ufEndereco) {
        this.ruaEndereco = ruaEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.ufEndereco = ufEndereco;
    }

    @Id
    @GeneratedValue
    private Long idEndereco;

    private String ruaEndereco;

    private String bairroEndereco;

    private String cidadeEndereco;

    @Column(length = 2)
    private String ufEndereco;

    public String getRuaEndereco() {
        return ruaEndereco;
    }

    public void setRuaEndereco(String ruaEndereco) {
        this.ruaEndereco = ruaEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadedEndereco(String cidadedEndereco) {
        this.cidadeEndereco = cidadedEndereco;
    }

    public String getUfEndereco() {
        return ufEndereco;
    }

    public void setUfEndereco(String ufEndereco) {
        this.ufEndereco = ufEndereco;
    }
}
