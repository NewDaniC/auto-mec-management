package com.utfpr.mecanica.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
//import java.util.Date;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cpf;
	private String nome;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant nascimeto;
	private String email;
	private String telefone;

	/*******************************************************/
	// PESSOA ENDERECO

	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	/*******************************************************/

	/*******************************************************/
	// PESSOA CLIENTE

	@OneToMany(mappedBy = "id.pessoa")
	private Set<Cliente> clientes = new HashSet<>();
	/*******************************************************/

	/*******************************************************/
	// PESSOA FUNCIONARIO

	@OneToMany(mappedBy = "id.pessoa")
	private Set<Funcionario> funcionarios = new HashSet<>();

	/*******************************************************/

	public Pessoa() {

	}

	public Pessoa(Long id, String cpf, String nome, Instant nascimeto, String email, String telefone,
			Endereco endereco) {
		super();
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.nascimeto = nascimeto;
		this.email = email;
		this.telefone = telefone;
		this.setEndereco(endereco);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Instant getNascimeto() {
		return nascimeto;
	}

	public void setNascimeto(Instant nascimeto) {
		this.nascimeto = nascimeto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public Set<Funcionario> getFuncionario() {
		return funcionarios;
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
}
