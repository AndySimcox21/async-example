package com.example.asyncexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AsyncExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncExampleApplication.class, args);
	}
}
