package com.utfpr.mecanica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.mecanica.entities.Cliente;
import com.utfpr.mecanica.entities.pk.ClientePK;

public interface ClienteRepository extends JpaRepository<Cliente, ClientePK> {

}