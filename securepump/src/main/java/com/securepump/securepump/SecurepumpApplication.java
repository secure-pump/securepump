package com.securepump.securepump;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EnableJpaRepositories (value = "com.securepump.dao")
@EntityScan(basePackages = {"com.securepump.model"})
@ComponentScan(basePackages = "com.securepump") 
public class SecurepumpApplication {
	public static void main(String[] args) {
		SpringApplication.run(SecurepumpApplication.class, args);
	}

}
