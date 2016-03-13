package com.br.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="tradicional_id", sequenceName="tradicional_seq")
public class Tradicional extends Pedido {
	
	private Mesa mesa;

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}
