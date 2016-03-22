package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Pedido;

public class DeliveryDao extends PedidoDao {

	public DeliveryDao(EntityManager eM) {
		super(eM);
		// TODO Auto-generated constructor stub
	}
	
	public Class<Pedido> getTypeClass() {
		return Pedido.class;
	}

}
