package com.mucheniski;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mucheniski.domains.Categoria;
import com.mucheniski.repositories.CategoriaRepository;

@SpringBootApplication
public class UmlUdemyProjetoFinalApplication implements CommandLineRunner {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(UmlUdemyProjetoFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Informática");
		Categoria categoria2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		
	}

}
