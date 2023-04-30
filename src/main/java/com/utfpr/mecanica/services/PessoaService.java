package com.utfpr.mecanica.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.mecanica.entities.*;
import com.utfpr.mecanica.repositories.*;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public Pessoa findById(Long id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.get();
	}
	
	public Pessoa insert(Pessoa obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Pessoa update(Long id, Pessoa obj) {
		Pessoa entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Pessoa entity, Pessoa obj) {
		entity.setCpf(obj.getCpf());
		entity.setNome(obj.getNome());
		entity.setNascimeto(obj.getNascimeto());
		entity.setEmail(obj.getEmail());
	}
}
