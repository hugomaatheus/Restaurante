package com.br.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="mesa_id", sequenceName="mesa_seq")
public class Mesa extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int numero;
	
	private int capacidade;
	
	@OneToMany
	@JoinTable(name="mesa_PedTradicional", joinColumns=@JoinColumn(name="mesa_id"),
	inverseJoinColumns=@JoinColumn(name="tradicional_id"))
	private List<Pedido> tradicionais;
	
	@OneToMany
	@JoinTable(name="mesa_Reserva", joinColumns=@JoinColumn(name="mesa_id"),
	inverseJoinColumns=@JoinColumn(name="reserva_id"))
	private List<Reserva> reservas;
	
	

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Pedido> getTradicionais() {
		return tradicionais;
	}

	public void setTradicionais(List<Pedido> tradicionais) {
		this.tradicionais = tradicionais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	//private List<Pedido> pedidos;
	
	//private List<Reserva> reservas;
	
	
}
