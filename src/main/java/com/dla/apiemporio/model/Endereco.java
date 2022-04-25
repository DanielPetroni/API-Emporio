package com.dla.apiemporio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Endereco {
    public Endereco(String ruaEndereco, String bairroEndereco, String cidadedEndereco, String ufEndereco) {
        this.ruaEndereco = ruaEndereco;
        this.bairroEndereco = bairroEndereco;
        this.cidadedEndereco = cidadedEndereco;
        this.ufEndereco = ufEndereco;
    }

    @Id
    @GeneratedValue
    private Long idEndereco;

    @Column(nullable = false)
    private String ruaEndereco;

    @Column(nullable = false)
    private String bairroEndereco;

    @Column(nullable = false)
    private String cidadedEndereco;

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

    public String getCidadedEndereco() {
        return cidadedEndereco;
    }

    public void setCidadedEndereco(String cidadedEndereco) {
        this.cidadedEndereco = cidadedEndereco;
    }

    public String getUfEndereco() {
        return ufEndereco;
    }

    public void setUfEndereco(String ufEndereco) {
        this.ufEndereco = ufEndereco;
    }
}
