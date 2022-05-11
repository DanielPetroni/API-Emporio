package com.dla.apiemporio.dto;

import java.io.Serializable;

import com.dla.apiemporio.entity.Produto;

import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DTOProduto extends Produto implements Serializable {
  private MultipartFile imageProduto;

  public MultipartFile getImageProduto() {
    return imageProduto;
  }

  public void setImageProduto(MultipartFile imageProduto) {
    System.out.println("entrou no set");
    this.imageProduto = imageProduto;
  }

}