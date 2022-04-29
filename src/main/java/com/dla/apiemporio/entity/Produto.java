package com.dla.apiemporio.entity;

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

    private int valorProdutoInCents;

    private int qtdEstoque = 0;

    private Date dataValidadeProduto;

    private String urlImagemProduto;

    @Column(unique = true)
    private Long gtinProduto;

    public Produto() {
    }

    public Produto(String nomeProduto, String descricaoProduto, int valorProdutoInCents, int qtdEstoque,
            Date dataValidadeProduto, Long gtinProduto, String urlImagemProduto) {
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorProdutoInCents = valorProdutoInCents;
        this.qtdEstoque = qtdEstoque;
        this.dataValidadeProduto = dataValidadeProduto;
        this.gtinProduto = gtinProduto;
        this.urlImagemProduto = urlImagemProduto;
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

    public int getValorProdutoInCents() {
        return valorProdutoInCents;
    }

    public void setValorProdutoInCents(int valorProdutoInCents) {
        this.valorProdutoInCents = valorProdutoInCents;
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
        this.valorProdutoInCents = produto.getValorProdutoInCents();
        this.qtdEstoque = produto.getQtdEstoque();
        this.dataValidadeProduto = produto.getDataValidadeProduto();
        this.gtinProduto = produto.getGtinProduto();
    }

    static public boolean isValid(Produto produto) {
        return produto.getNomeProduto() != null && produto.getDescricaoProduto() != null
                && produto.getDataValidadeProduto() != null
                && produto.getValorProdutoInCents() != 0 && produto.getGtinProduto() != null;
    }

    public String geturlImagemProduto() {
        return urlImagemProduto;
    }

    public void seturlImagemProduto(String imagemProduto) {
        this.urlImagemProduto = imagemProduto;
    }
}
