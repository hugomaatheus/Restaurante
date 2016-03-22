package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Mesa;

public class MesaDao extends AbstractDao<Mesa> {

	public MesaDao(EntityManager eM) {
		super(eM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Mesa> getTypeClass() {
		// TODO Auto-generated method stub
		return Mesa.class;
	}
	
}
