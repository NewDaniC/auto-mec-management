package com.utfpr.mecanica.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.mecanica.entities.Cidade;
import com.utfpr.mecanica.services.CidadeService;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeResource {

	@Autowired 
	private CidadeService service;
	
	@GetMapping
	public ResponseEntity<List<Cidade>> findAll() {
		List<Cidade> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {
		Cidade obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
