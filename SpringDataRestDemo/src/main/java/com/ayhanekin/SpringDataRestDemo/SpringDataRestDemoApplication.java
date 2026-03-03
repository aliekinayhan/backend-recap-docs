package com.ayhanekin.SpringDataRestDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRestDemoApplication {

	/*
	Repository automatically generates REST endpoints

    Returns HAL JSON by default

    Header mismatch can cause media type errors

    !Switch to a classic controller if custom business logic is required!

    Not commonly preferred in large-scale enterprise projects

	*/


    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestDemoApplication.class, args);
    }

}
