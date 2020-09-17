package com.example.ticproject.app;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		Application.launch(ApplicationExample.class, args);
	}

}
