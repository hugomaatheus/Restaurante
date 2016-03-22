package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.ItemPedido;

public class ItemPedidoDao extends AbstractDao<ItemPedido> {

	public ItemPedidoDao(EntityManager eM) {
		super(eM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<ItemPedido> getTypeClass() {
		// TODO Auto-generated method stub
		return ItemPedido.class;
	}

}
