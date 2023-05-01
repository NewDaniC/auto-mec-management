package com.utfpr.mecanica.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.mecanica.entities.Cliente;
import com.utfpr.mecanica.entities.pk.ClientePK;
import com.utfpr.mecanica.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public List<Cliente> findAll() {
		return repository.findAll();
	}

//	public Cliente findById(Long id) {
//		Optional<Cliente> obj = repository.findById(id);
//		return obj.get();
//	}
	
	public Cliente findById(Long pessoa_id, Long veiculo_id) {
		ClientePK id = new ClientePK();
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
	}
	
}
