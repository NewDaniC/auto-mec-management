package com.utfpr.mecanica.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	/*******************************************************/
	// MANUTENCAO SERVICO
	
	@OneToMany(mappedBy = "id.manutencao")
	private Set<Servico> servico = new HashSet<>();
	/*******************************************************/
	
	/*******************************************************/
	// MANUTENCAO PAGAMENTO
	
	@OneToOne(mappedBy = "manutencao", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	/*******************************************************/
	
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
	
	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<Servico> getServico(){
		return servico;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for (Servico x : servico) {
			sum += x.getSubTotal();
		}
		return sum;
	}
	
	/*
	public Double getTotal() {
	    double sum = 0.0;
	    for (Servico x : servico) {
	        if (x.getDesconto() == 0.0) {
	            sum += x.getSubTotal();
	        } else {
	            sum += x.getTotalDesconto();
	        }
	    }
	    return sum;
	}
	*/
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
