package com.br.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="cliente_id", sequenceName="cliente_seq")
public class Cliente extends Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private List<Pedido> deliverys;
	
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
