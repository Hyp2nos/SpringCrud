package com.fifa.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Finupp1Application {

	public static void main(String[] args) {
		System.out.println("2 eme commit");
		System.out.println("3 eme");
		SpringApplication.run(Finupp1Application.class, args);
	}

}
