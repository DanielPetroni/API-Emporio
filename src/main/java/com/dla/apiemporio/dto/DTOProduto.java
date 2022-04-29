package com.dla.apiemporio.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

class DTOProduto {
  private String nomeProduto;

  private String descricaoProduto;

  private int valorProdutoInCents;

  private int qtdEstoque = 0;

  private Date dataValidadeProduto;

  private MultipartFile imagemProduto;

  public DTOProduto(String nomeProduto, String descricaoProduto, int valorProdutoInCents, int qtdEstoque,
      Date dataValidadeProduto, MultipartFile imagemProduto) {
    this.nomeProduto = nomeProduto;
    this.descricaoProduto = descricaoProduto;
    this.valorProdutoInCents = valorProdutoInCents;
    this.qtdEstoque = qtdEstoque;
    this.dataValidadeProduto = dataValidadeProduto;
    this.imagemProduto = imagemProduto;
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

  public void setDataValidadeProduto(Date dataValidadeProduto) {
    this.dataValidadeProduto = dataValidadeProduto;
  }

  public MultipartFile getimagemProduto() {
    return imagemProduto;
  }

  public void setimagemProduto(MultipartFile imagemProduto) {
    this.imagemProduto = imagemProduto;
  }

}