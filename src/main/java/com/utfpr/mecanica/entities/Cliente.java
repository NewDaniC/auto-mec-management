package com.utfpr.mecanica.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utfpr.mecanica.entities.pk.ClientePK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ClientePK id = new ClientePK();
	
	private Integer satisfacao;
	
	public Cliente() {
		
	}
	
	public Cliente(Pessoa pessoa, Veiculo veiculo, Integer satisfacao) {
		super();
		id.setPessoa(pessoa);
		id.setVeiculo(veiculo);
		this.setSatisfacao(satisfacao);
	}
	
	@JsonIgnore
	public Pessoa getPessoa() {
		return id.getPessoa();
	}
	
	public void setPessoa(Pessoa pessoa) {
		id.setPessoa(pessoa);
	}
	
	@JsonIgnore
	public Veiculo getVeiculo() {
		return id.getVeiculo();
	}
	
	public void setVeiculo(Veiculo veiculo) {
		id.setVeiculo(veiculo);
	}

	public Integer getSatisfacao() {
		return satisfacao;
	}

	public void setSatisfacao(Integer satisfacao) {
		this.satisfacao = satisfacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}
}
