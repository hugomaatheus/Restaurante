package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Cliente;

public class ClienteDao extends AbstractDao<Cliente> {

	public ClienteDao(EntityManager eM) {
		super(eM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Cliente> getTypeClass() {
		return Cliente.class;
	}

}
