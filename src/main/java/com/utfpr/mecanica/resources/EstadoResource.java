package com.utfpr.mecanica.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.mecanica.entities.Estado;
import com.utfpr.mecanica.services.EstadoService;

@RestController
@RequestMapping(value = "/estado")
public class EstadoResource {

	@Autowired 
	private EstadoService service;
	
	@GetMapping
	public ResponseEntity<List<Estado>> findAll() {
		List<Estado> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Estado> findById(@PathVariable Long id) {
		Estado obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
