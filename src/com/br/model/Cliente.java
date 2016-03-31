package com.br.model;


import java.util.Collection;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.br.util.Status;

@Entity
@SequenceGenerator(name="cliente_id", sequenceName="cliente_seq")
public class Cliente extends Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinTable(name="cliente_delivery", joinColumns=@JoinColumn(name="cliente_id"),
	inverseJoinColumns=@JoinColumn(name="delivery_id"))
	private Collection<Delivery> delivery;
	
	private String login;
	private String senha;
	private String email;
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Embedded
	private Endereco endereco;


	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Delivery> getDeliverys() {
		return delivery;
	}

	public void setDeliverys(Collection<Delivery> delivery) {
		this.delivery = delivery;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Nome: %s\n"
				+ "Email: %s\n"
				+ "Endereço => %s", getNome(), getEmail(), getEndereco());
	}
	
}
