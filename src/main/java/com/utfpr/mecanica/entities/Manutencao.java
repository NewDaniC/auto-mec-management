package com.utfpr.mecanica.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_manutencao")
public class Manutencao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant dataEntrada;
	private Instant dataSaida;
	private Integer kilometragem;
	
	public Manutencao () {
		
	}
	
	public Manutencao(Long id, Instant dataEntrada, Instant dataSaida, Integer kilometragem) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.kilometragem = kilometragem;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Instant getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Instant dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Instant getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Instant dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Integer getKilometragem() {
		return kilometragem;
	}
	public void setKilometragem(Integer kilometragem) {
		this.kilometragem = kilometragem;
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
		Manutencao other = (Manutencao) obj;
		return Objects.equals(id, other.id);
	}
}