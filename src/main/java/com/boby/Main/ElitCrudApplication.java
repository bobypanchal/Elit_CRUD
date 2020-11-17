package com.boby.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.boby")
public class ElitCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElitCrudApplication.class, args);
	}

}
