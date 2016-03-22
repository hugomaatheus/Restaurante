package com.br.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="delivery_id", sequenceName="delivery_seq")
@PrimaryKeyJoinColumn(name="pedido_id")
public class Delivery extends Pedido {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
	
	private Double trocoPara;
	
	private Cliente cliente;
	
	
	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

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
