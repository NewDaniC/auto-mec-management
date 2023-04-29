package com.utfpr.mecanica.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.mecanica.entities.Manutencao;
import com.utfpr.mecanica.services.ManutencaoService;

@RestController
@RequestMapping(value = "/manutencao")
public class ManutencaoResource {

	@Autowired 
	private ManutencaoService service;
	
	@GetMapping
	public ResponseEntity<List<Manutencao>> findAll() {
		List<Manutencao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Manutencao> findById(@PathVariable Long id) {
		Manutencao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
