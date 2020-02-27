package com.github.rakhmedovrs.SpringBootApp28.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.rakhmedovrs.SpringBootApp28.web")
public class SpringBootApp28Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp28Application.class, args);
	}

}
