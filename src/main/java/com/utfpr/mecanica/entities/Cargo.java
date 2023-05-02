package com.utfpr.mecanica.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.utfpr.mecanica.entities.enums.TipoCargo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cargo")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double salarioBase;
	private String descricao;
	private Integer tipoCargo;
	
	/*******************************************************/
	// CARGO PESSOA
	
	@OneToMany(mappedBy = "id.cargo")
	private Set<Funcionario> cargos = new HashSet<>();
	/*******************************************************/
	
	public Cargo() {
		
	}
	
	public Cargo(Long id, Double salarioBase, String descricao, TipoCargo tipoCargo) {
		super();
		this.id = id;
		this.salarioBase = salarioBase;
		this.descricao = descricao;
		setTipoCargo(tipoCargo);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public TipoCargo getTipoCargo() {
		return TipoCargo.valueOf(tipoCargo);
	}

	public void setTipoCargo(TipoCargo tipoCargo) {
		if (tipoCargo != null) {
			this.tipoCargo = tipoCargo.getCode();
		}
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
		Cargo other = (Cargo) obj;
		return Objects.equals(id, other.id);
	}
	
	public Set<Pessoa> getPessoaCargo() {
		Set<Pessoa> set = new HashSet<>();
		for (Funcionario x : cargos) {
			set.add(x.getPessoa());
		}
		return set;
	}
}
