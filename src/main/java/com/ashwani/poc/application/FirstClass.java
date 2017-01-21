package com.ashwani.poc.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@ComponentScan("com.ashwani")
public class FirstClass {
	
	public static void main(String[] args) {
		System.out.println("Starting the Boot Application for POC!!");
		 SpringApplication.run(FirstClass.class, args);
	}
}
