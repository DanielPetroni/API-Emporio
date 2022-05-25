package com.dla.apiemporio.config;

import com.dla.apiemporio.service.ClienteService;
import com.dla.apiemporio.service.EnderecoService;
import com.dla.apiemporio.service.ProdutoService;
import com.dla.apiemporio.service.UserService;
import com.dla.apiemporio.shared.CloudinaryShared.CloudinaryShared;

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

    @Bean
    public ClienteService clienteService() {
        return new ClienteService();
    }

    @Bean
    public CloudinaryShared cloudinaryShared() {
        return new CloudinaryShared();
    }

}
