package com.javacodegeeks.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.javacodegeeks.examples.beans.Animal;
import com.javacodegeeks.examples.beans.Dog;

@SpringBootApplication
@ImportResource("classpath:/applicationContext.xml")
public class IocSpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =SpringApplication.run(
				IocSpringApplication.class, args);
		
		Animal animal = context.getBean("myAnimal", Animal.class);
        
        System.out.println(animal.getFavoritePastime());
        
        context.close();
	}

}
