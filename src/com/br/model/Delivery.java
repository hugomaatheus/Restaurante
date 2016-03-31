package com.br.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="delivery_id", sequenceName="delivery_seq")
@PrimaryKeyJoinColumn(name="pedido_id")
public class Delivery extends Pedido {
	
	
	private Double trocoPara;
	
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Cliente cliente;
	

	public Double getTrocoPara() {
		return trocoPara;
	}

	public void setTrocoPara(Double trocoPara) {
		this.trocoPara = trocoPara;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
