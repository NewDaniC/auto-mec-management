package com.utfpr.mecanica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.mecanica.entities.Servico;
import com.utfpr.mecanica.entities.pk.ServicoPK;

public interface ServicoRepository extends JpaRepository<Servico, ServicoPK> {

}