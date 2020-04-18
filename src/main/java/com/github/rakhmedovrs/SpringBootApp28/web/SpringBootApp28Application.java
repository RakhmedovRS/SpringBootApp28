package com.github.rakhmedovrs.SpringBootApp28.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.github.rakhmedovrs.SpringBootApp28")
@EntityScan(basePackages = {"com.github.rakhmedovrs.SpringBootApp28.web.model"})
public class SpringBootApp28Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp28Application.class, args);
	}

}
