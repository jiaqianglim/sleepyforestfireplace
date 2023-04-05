package com.togetherness.rsocketserver;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RSocketserverApplication {

	public static void main(String[] args) throws IOException{
		SpringApplication.run(RSocketserverApplication.class, args);
		System.in.read();
	}

}
