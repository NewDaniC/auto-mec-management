package com.utfpr.mecanica.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.mecanica.entities.Funcionario;
import com.utfpr.mecanica.services.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioResource {

	@Autowired 
	private FuncionarioService service;
	
	@GetMapping
	public ResponseEntity<List<Funcionario>> findAll() {
		List<Funcionario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

//	@GetMapping(value = "/{id}")
//	public ResponseEntity<Funcionario> findById(@PathVariable Long pessoa_id, @PathVariable Long cargo_id) {
//		Funcionario obj = service.findById(id);
//		return ResponseEntity.ok().body(obj);
//	}
}
