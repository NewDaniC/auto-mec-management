package com.utfpr.mecanica.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utfpr.mecanica.entities.enums.EstadoPagamento;
import com.utfpr.mecanica.entities.enums.TipoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer estadoPagamento;
	private Integer tipoPagamento;
	private Instant dataVencimentoBol;
	private Instant dataPagametoBol;
	private Double desconto;
	private Integer numeroDeParcelas;
	
	/*******************************************************/
	// PAGAMENTO MANUTENCAO
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Manutencao manutencao;
	/*******************************************************/
	
	public Pagamento() {
	}
	
	public Pagamento(Long id, EstadoPagamento estadoPagamento, TipoPagamento tipoPagamento, 
			Instant dataVencimentoBol, Instant dataPagametoBol, Double desconto, Integer numeroDeParcelas, Manutencao manutencao) {
		super();
		this.id = id;
		setEstadoPagamento(estadoPagamento);
		setTipoPagamento(tipoPagamento);
		this.dataVencimentoBol = dataVencimentoBol;
		this.dataPagametoBol = dataPagametoBol;
		this.desconto = desconto;
		this.numeroDeParcelas = numeroDeParcelas;
		this.manutencao = manutencao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoPagamento getEstadoPagamento() {
		return EstadoPagamento.valueOf(estadoPagamento);
	}

	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		if (estadoPagamento != null) {
			this.estadoPagamento = estadoPagamento.getCode();
		}
	}
	
	public TipoPagamento getTipoPagamento() {
		return TipoPagamento.valueOf(tipoPagamento);
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		if (tipoPagamento != null) {
			this.tipoPagamento = tipoPagamento.getCode();
		}
	}
	
	public Instant getDataVencimentoBol() {
		return dataVencimentoBol;
	}

	public void setDataVencimentoBol(Instant dataVencimentoBol) {
		this.dataVencimentoBol = dataVencimentoBol;
	}

	public Instant getDataPagametoBol() {
		return dataPagametoBol;
	}

	public void setDataPagametoBol(Instant dataPagametoBol) {
		this.dataPagametoBol = dataPagametoBol;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Manutencao getManutencao() {
		return manutencao;
	}

	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}
	
	public Double getTotalPagamento() {
	    Double total = manutencao.getTotal();
	    
	    if (numeroDeParcelas > 2) {
	        Double juros = total * 0.03 * numeroDeParcelas;
	        total += juros;
	    }    
	    
	    if (desconto == 0.0) {
	    	return total;
	    } else {
	    	return total - (total * desconto / 100);
	    }
	}
	
	public Double getValorParcela() {
		Double valorParcela = 0.0;
		valorParcela = getTotalPagamento()/numeroDeParcelas;
	    return valorParcela;
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
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}


}
