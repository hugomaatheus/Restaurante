package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Endereco;

public class EnderecoDao extends AbstractDao<Endereco>{

	public EnderecoDao(EntityManager eM) {
		super(eM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Endereco> getTypeClass() {
		return Endereco.class;
	}

}
