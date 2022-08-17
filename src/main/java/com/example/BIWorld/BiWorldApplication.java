package com.example.BIWorld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("class com.example.BIWorld.models")

public class BiWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiWorldApplication.class, args);
	}

}
