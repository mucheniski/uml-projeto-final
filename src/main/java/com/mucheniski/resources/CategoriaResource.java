package com.mucheniski.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mucheniski.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@GetMapping
	public List<Categoria> listar() {
		
		Categoria categoria1 = new Categoria(1, "Informática");
		Categoria categoria2 = new Categoria(2, "Escritório");
		
		List<Categoria> list = new ArrayList<>();
		list.add(categoria1);
		list.add(categoria2);
		
		return list;
		
	}
	
}
