package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

	ApplicationContext appContext= SpringApplication.run(DemoApplication.class, args);
	BinarySearch binary=appContext.getBean(BinarySearch.class);
	binary.getValue(new int[]{1,2,3,4,4},4);

	}

}
