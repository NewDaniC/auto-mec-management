package com.utfpr.mecanica.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.mecanica.entities.*;
import com.utfpr.mecanica.repositories.*;

@Service
public class ManutencaoService {

	@Autowired
	private ManutencaoRepository repository;

	public List<Manutencao> findAll() {
		return repository.findAll();
	}

	public Manutencao findById(Long id) {
		Optional<Manutencao> obj = repository.findById(id);
		return obj.get();
	}
}
