package com.utfpr.mecanica.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.mecanica.entities.*;
import com.utfpr.mecanica.repositories.*;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.get();
	}
}
