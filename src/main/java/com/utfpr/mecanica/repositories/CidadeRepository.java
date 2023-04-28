package com.utfpr.mecanica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.mecanica.entities.*;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}