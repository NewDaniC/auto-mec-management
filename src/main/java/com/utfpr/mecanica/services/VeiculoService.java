package com.utfpr.mecanica.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.mecanica.entities.*;
import com.utfpr.mecanica.repositories.*;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository repository;

	public List<Veiculo> findAll() {
		return repository.findAll();
	}

	public Veiculo findById(Long id) {
		Optional<Veiculo> obj = repository.findById(id);
		return obj.get();
	}
}
