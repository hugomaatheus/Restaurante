package com.br.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

import com.br.util.Status;

@Entity
@SequenceGenerator(name="tradicional_id", sequenceName="tradicional_seq")
@PrimaryKeyJoinColumn(name="pedido_id")
public class Tradicional extends Pedido {
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mesa_id")
	private Mesa mesa;
	
	@Enumerated(EnumType.STRING)
	private Status status;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Mesa: %d %d %d", getMesa().getNumero(), getMesa().getId(), getId());
	}

}
