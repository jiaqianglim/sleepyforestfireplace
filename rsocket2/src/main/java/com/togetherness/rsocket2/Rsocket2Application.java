package com.togetherness.rsocket2;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Rsocket2Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Rsocket2Application.class, args);
		System.in.read();
	}

}
