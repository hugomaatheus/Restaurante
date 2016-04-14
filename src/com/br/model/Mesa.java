package com.br.model;


import java.util.Collection;

import javax.persistence.CascadeType;
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
@SequenceGenerator(name="mesa_id", sequenceName="mesa_seq")
//@NamedQuery(name="fecharMesa", query="DELETE FROM Mesa m "
//		+ "WHERE m IN(SELECT t.mesa FROM Tradicional WHERE t.mesa.id LIKE :id)")
public class Mesa extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int numero;
	
	private int capacidade;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="mesa_PedTradicional", joinColumns=@JoinColumn(name="mesa_id"),
	inverseJoinColumns=@JoinColumn(name="tradicional"))
	private Collection<Tradicional> tradicionais;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="mesa_Reserva",joinColumns=@JoinColumn(name="mesa_id"),
	inverseJoinColumns=@JoinColumn(name="reserva"))
	private Collection<Reserva> reservas;
	
	public Mesa(int numero, int capacidade) {
		super();
		this.numero = numero;
		this.capacidade = capacidade;
	}
	
	public Mesa() {}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Collection<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Collection<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Collection<Tradicional> getTradicionais() {
		return tradicionais;
	}

	public void setTradicionais(Collection<Tradicional> tradicionais) {
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%d %d %s", getId(), getNumero(), getStatus());
	}
	
}
