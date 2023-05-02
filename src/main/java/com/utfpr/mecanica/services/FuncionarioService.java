package com.utfpr.mecanica.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.mecanica.entities.Funcionario;
import com.utfpr.mecanica.entities.pk.FuncionarioPK;
import com.utfpr.mecanica.repositories.FuncionarioRepository;
import com.utfpr.mecanica.repositories.PessoaRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	public List<Funcionario> findAll() {
		return repository.findAll();
	}

//	public Funcionario findById(Long id) {
//		Optional<Funcionario> obj = repository.findById(id);
//		return obj.get();
//	}
	
	public Funcionario findById(Long pessoa_id, Long cargo_id) {
		FuncionarioPK id = new FuncionarioPK();
		Optional<Funcionario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
	}
	
//	public Funcionario findById(Long id) {
//	    Optional<Funcionario> obj = repository.findById(id);
//	    return obj.orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
//	}
	
}
