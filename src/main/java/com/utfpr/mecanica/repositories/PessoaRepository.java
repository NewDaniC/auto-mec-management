package com.utfpr.mecanica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.mecanica.entities.*;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}