package com.example.app.gituserapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GitUserAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(GitUserAppApplication.class, args);
	}

	@Bean
	RestTemplate template(){

		return new RestTemplate();
	}

}
