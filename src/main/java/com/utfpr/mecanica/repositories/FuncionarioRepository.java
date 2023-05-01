package com.utfpr.mecanica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utfpr.mecanica.entities.Funcionario;
import com.utfpr.mecanica.entities.pk.FuncionarioPK;

public interface FuncionarioRepository extends JpaRepository<Funcionario, FuncionarioPK> {

}