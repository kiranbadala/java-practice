package com.spring.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.spring.security.config.SecurityConfig;

@SpringBootApplication//(exclude=SecurityAutoConfiguration.class)
@ComponentScan("com.spring.security")
public class PracticeApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(new Class[] {PracticeApplication.class,SecurityConfig.class}, args);
	}

}
