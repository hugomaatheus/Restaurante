package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Pedido;

public class PedidoDao extends AbstractDao<Pedido> {

	public PedidoDao(EntityManager eM) {
		super(eM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Pedido> getTypeClass() {
		return Pedido.class;
	}

}
