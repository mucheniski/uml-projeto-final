package com.mucheniski.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mucheniski.domains.Pedido;
import com.mucheniski.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
		Pedido pedido = pedidoService.findById(id);
		return ResponseEntity.ok().body(pedido);
	}

}
