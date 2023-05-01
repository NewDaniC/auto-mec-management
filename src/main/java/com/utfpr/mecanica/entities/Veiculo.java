package com.utfpr.mecanica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utfpr.mecanica.entities.enums.CorDoVeiculo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String placa;
	private Integer corDoVeiculo;
	private Integer ano;
	
	/*******************************************************/
	// VEICULO PESSOA
	
	@OneToMany(mappedBy = "id.veiculo")
	private Set<Cliente> veiculos = new HashSet<>();
	/*******************************************************/
	
	/*******************************************************/
	// VEICULO MANUTENCAO
	
	@JsonIgnore
	@OneToMany(mappedBy = "veiculo")
	private List<Manutencao> manutencaoVeiculo = new ArrayList<>();
	/*******************************************************/

	public Veiculo() {

	}
	
	public Veiculo(Long id, String placa, Integer ano, CorDoVeiculo corVeiculo) {
		super();
		this.id = id;
		this.placa = placa;
		this.ano = ano;
		setCorDoVeiculo(corVeiculo);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
	public CorDoVeiculo getCorDoVeiculo() {
		return CorDoVeiculo.valueOf(corDoVeiculo);
	}

	public void setCorDoVeiculo(CorDoVeiculo corDoVeiculo) {
		if (corDoVeiculo != null) {
			this.corDoVeiculo = corDoVeiculo.getCode();
		}
	}
	
	public List<Manutencao> getManutencaoVeiculo() {
		return manutencaoVeiculo;
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
		Veiculo other = (Veiculo) obj;
		return Objects.equals(id, other.id);
	}

	public Set<Pessoa> getPessoasVeiculo() {
		Set<Pessoa> set = new HashSet<>();
		for (Cliente x : veiculos) {
			set.add(x.getPessoa());
		}
		return set;
	}
		
}
