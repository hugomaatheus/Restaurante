package com.br.model;


import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="cliente_id", sequenceName="cliente_seq")
public class Cliente extends Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany
	@JoinTable(name="cliente_delivery", joinColumns=@JoinColumn(name="cliente_id"),
	inverseJoinColumns=@JoinColumn(name="delivery_id"))
	private List<Pedido> deliverys;
	
	private String login;
	private String senha;
	private String email;
	private String nome;
	
	@Embedded
	private Endereco endereco;
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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

	public List<Pedido> getDeliverys() {
		return deliverys;
	}

	public void setDeliverys(List<Pedido> deliverys) {
		this.deliverys = deliverys;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	

}
