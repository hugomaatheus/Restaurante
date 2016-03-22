package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Reserva;

public class ReservaDao extends AbstractDao<Reserva>{

	public ReservaDao(EntityManager eM) {
		super(eM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Reserva> getTypeClass() {
		// TODO Auto-generated method stub
		return Reserva.class;
	}

	
	
}
