package com.utfpr.mecanica.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.mecanica.entities.Pagamento;
import com.utfpr.mecanica.repositories.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repository;

	public List<Pagamento> findAll() {
		return repository.findAll();
	}

	public Pagamento findById(Long id) {
		Optional<Pagamento> obj = repository.findById(id);
		return obj.get();
	}
}
