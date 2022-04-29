package com.dla.apiemporio.dto;

import java.io.Serializable;
import java.sql.Date;

import com.dla.apiemporio.entity.Produto;

import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DTOProduto extends Produto implements Serializable {
  private String nomeProduto;

  private String descricaoProduto;

  private int valorProdutoInCents;

  private int qtdEstoque = 0;

  private Date dataValidadeProduto;

  private MultipartFile imageProdutos;

  private Long gtinProduto;

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

  public MultipartFile getImageProdutos() {
    return imageProdutos;
  }

  public void setImageProdutos(MultipartFile imageProdutos) {
    this.imageProdutos = imageProdutos;
  }

  public Long getGtinProduto() {
    return gtinProduto;
  }

  public void setGtinProduto(Long gtinProduto) {
    this.gtinProduto = gtinProduto;
  }

}