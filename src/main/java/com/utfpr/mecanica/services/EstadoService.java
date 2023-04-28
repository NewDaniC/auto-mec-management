package com.utfpr.mecanica.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.mecanica.entities.*;
import com.utfpr.mecanica.repositories.*;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repository;

	public List<Estado> findAll() {
		return repository.findAll();
	}

	public Estado findById(Long id) {
		Optional<Estado> obj = repository.findById(id);
		return obj.get();
	}
}
