package com.br.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="tradicional_id", sequenceName="tradicional_seq")
@PrimaryKeyJoinColumn(name="pedido_id")
public class Tradicional extends Pedido {
	
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private Long id;
	
	private Mesa mesa;

	
	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}
