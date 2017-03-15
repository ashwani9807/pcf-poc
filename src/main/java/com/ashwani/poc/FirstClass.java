package com.ashwani.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FirstClass {
	
	public static void main(String[] args) {
		 System.out.println("Starting the Boot Application for POC!!");
		 SpringApplication.run(FirstClass.class, args);
	}
	
}
