package com.utfpr.mecanica.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.mecanica.entities.Veiculo;
import com.utfpr.mecanica.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculo")
public class VeiculoResource {

	@Autowired 
	private VeiculoService service;
	
	@GetMapping
	public ResponseEntity<List<Veiculo>> findAll() {
		List<Veiculo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Veiculo> findById(@PathVariable Long id) {
		Veiculo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
