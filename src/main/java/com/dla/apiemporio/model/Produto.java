package com.dla.apiemporio.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Long idProduto;

    private String nomeProduto;

    private String descricaoProduto;

    private double valorProduto;

    private int qtdEstoque = 0;

    private Date dataValidadeProduto;

    @Column(unique = true)
    private Long gtinProduto;

    public Produto() {
    }

    public Produto(String nomeProduto, String descricaoProduto, double valorProduto, int qtdEstoque,
            Date dataValidadeProduto, Long gtinProduto) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorProduto = valorProduto;
        this.qtdEstoque = qtdEstoque;
        this.dataValidadeProduto = dataValidadeProduto;
        this.gtinProduto = gtinProduto;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Date getDataValidadeProduto() {
        return dataValidadeProduto;
    }

    public void setDataValidade(Date dataValidadeProduto) {
        this.dataValidadeProduto = dataValidadeProduto;
    }

    public Long getGtinProduto() {
        return gtinProduto;
    }

    public void setGtin(Long gtin) {
        this.gtinProduto = gtin;
    }

    public void setFromObject(Produto produto) {
        this.nomeProduto = produto.getNomeProduto();
        this.descricaoProduto = produto.getDescricaoProduto();
        this.valorProduto = produto.getValorProduto();
        this.qtdEstoque = produto.getQtdEstoque();
        this.dataValidadeProduto = produto.getDataValidadeProduto();
        this.gtinProduto = produto.getGtinProduto();
    }

    static public boolean isValid(Produto produto) {
        return produto.getNomeProduto() != null && produto.getDescricaoProduto() != null
                && produto.getDataValidadeProduto() != null
                && produto.getValorProduto() != 0.0 && produto.gtinProduto != null;
    }
}
