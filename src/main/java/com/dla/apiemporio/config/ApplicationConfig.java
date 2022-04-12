package com.dla.apiemporio.config;

import com.dla.apiemporio.service.ProdutoService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ProdutoService produtoService(){
        return new ProdutoService();
    }
    
}
