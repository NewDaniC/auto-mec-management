package com.utfpr.mecanica.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.utfpr.mecanica.entities.pk.ServicoPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_servico")
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ServicoPK id = new ServicoPK();
	
	private Double preco;
	private Integer quantidade;
	private Double desconto;
	private String DescricaoServico;
	
	public Servico() {
		
	}

	public Servico(Manutencao manutencao, Item item, Double preco, Integer quantidade, Double desconto, String descricaoServico) {
		super();
		id.setManutencao(manutencao);
		id.setItem(item);
		this.setPreco(preco);
		this.setQuantidade(quantidade);
		this.setDesconto(desconto);
		setDescricaoServico(descricaoServico);
	}
	
	@JsonIgnore
	public Manutencao getManutencao() {
		return id.getManutencao();
	}
	
	public void setManutencao(Manutencao manutencao) {
		id.setManutencao(manutencao);
	}
	
	public Item getItem() {
		return id.getItem();
	}
	
	public void setItem(Item item) {
		id.setItem(item);
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public String getDescricaoServico() {
		return DescricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		DescricaoServico = descricaoServico;
	}
	
	/*
	public Double getSubTotal() {
		return preco * quantidade;
	}
	*/
	public Double getSubTotal() {
	    double subtotal = preco * quantidade;
	    if (desconto != null) {
	        subtotal -= subtotal * (desconto / 100.0);
	    }
	    return subtotal;
	}
	
	public Double getTotalDesconto() {
		return (desconto / 100.0) * quantidade * preco;
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
		Servico other = (Servico) obj;
		return Objects.equals(id, other.id);
	}
}
