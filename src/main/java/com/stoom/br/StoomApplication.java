package com.stoom.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StoomApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoomApplication.class, args);
	}

}
