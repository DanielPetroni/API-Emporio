package com.dla.apiemporio.config;

import com.dla.apiemporio.service.EnderecoService;
import com.dla.apiemporio.service.ProdutoService;
import com.dla.apiemporio.service.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public ProdutoService produtoService() {
        return new ProdutoService();
    }

    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public EnderecoService enderecoService() {
        return new EnderecoService();
    }

}
