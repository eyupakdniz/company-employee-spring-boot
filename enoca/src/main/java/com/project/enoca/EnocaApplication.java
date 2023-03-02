package com.project.enoca;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.project.enoca.repository")
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class EnocaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnocaApplication.class, args);
	}

}
