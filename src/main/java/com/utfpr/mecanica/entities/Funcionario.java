package com.utfpr.mecanica.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utfpr.mecanica.entities.pk.FuncionarioPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FuncionarioPK id = new FuncionarioPK();
	
	private Double salario;
	private Instant dataAdmissao;
	private Instant dataRecisao;

	public Funcionario() {

	}

	public Funcionario(Pessoa pessoa, Cargo cargo, Double salario, Instant dataAdmissao, Instant dataRecisao) {
		super();
		id.setPessoa(pessoa);
		id.setCargo(cargo);
		this.setSalario(salario);
		this.setDataAdmissao(dataAdmissao);
		this.setDataRecisao(dataRecisao);
	}
	
	@JsonIgnore
	public Pessoa getPessoa() {
		return id.getPessoa();
	}
	
	public void setPessoa(Pessoa pessoa) {
		id.setPessoa(pessoa);
	}
	
	@JsonIgnore
	public Cargo getCargo() {
		return id.getCargo();
	}
	
	public void setCargo(Cargo cargo) {
		id.setCargo(cargo);
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Instant getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Instant dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Instant getDataRecisao() {
		return dataRecisao;
	}

	public void setDataRecisao(Instant dataRecisao) {
		this.dataRecisao = dataRecisao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataAdmissao, dataRecisao);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(dataAdmissao, other.dataAdmissao) && Objects.equals(dataRecisao, other.dataRecisao);
	}
}
