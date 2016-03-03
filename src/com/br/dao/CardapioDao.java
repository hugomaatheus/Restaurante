package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Cardapio;

public class CardapioDao extends AbstractDao<Cardapio> {

	public CardapioDao(EntityManager eM) {
		super(eM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Cardapio> getTypeClass() {
		return Cardapio.class;
	}

}
