package com.utfpr.mecanica.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.mecanica.entities.*;
import com.utfpr.mecanica.repositories.*;

@Service
public class CargoService {

	@Autowired
	private CargoRepository repository;

	public List<Cargo> findAll() {
		return repository.findAll();
	}

	public Cargo findById(Long id) {
		Optional<Cargo> obj = repository.findById(id);
		return obj.get();
	}
}
