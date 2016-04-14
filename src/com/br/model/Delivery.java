package com.br.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@SequenceGenerator(name="delivery_id", sequenceName="delivery_seq")
@Table(name="delivery")
@PrimaryKeyJoinColumn(name="pedido_id")
public class Delivery extends Pedido {
	
	
	private Double trocoPara;
	
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Cliente cliente;
		
	public Delivery(Double trocoPara, Cliente cliente) {
		super();
		this.trocoPara = trocoPara;
		this.cliente = cliente;
	}
	
	public Delivery() {}

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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Cliente: %s\n Id - Pedido: %s\n Troco para: %s", getCliente(), getId(), getTrocoPara());
	}
}
