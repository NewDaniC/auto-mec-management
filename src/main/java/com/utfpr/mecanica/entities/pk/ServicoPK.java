package com.utfpr.mecanica.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import com.utfpr.mecanica.entities.Item;
import com.utfpr.mecanica.entities.Manutencao;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ServicoPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "manutencao_id")
	private Manutencao manutencao;
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	private Item item;
	
	public Manutencao getManutencao() {
		return manutencao;
	}
	public void setManutencao(Manutencao manutencao) {
		this.manutencao = manutencao;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(item, manutencao);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServicoPK other = (ServicoPK) obj;
		return Objects.equals(item, other.item) && Objects.equals(manutencao, other.manutencao);
	}
	
	

}
