package com.para.paramiel;

import com.para.paramiel.repositories.CategoryRepository;
import com.para.paramiel.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParamielApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ParamielApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {


	}
}