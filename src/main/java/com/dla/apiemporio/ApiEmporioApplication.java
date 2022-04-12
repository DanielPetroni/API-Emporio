package com.dla.apiemporio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.dla.apiemporio.repository")
@SpringBootApplication
public class ApiEmporioApplication {
	public static void main(String[] args) {
		SpringApplication.run(ApiEmporioApplication.class, args);
	}

}


