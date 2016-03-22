package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Categoria;

public class CategoriaDao extends AbstractDao<Categoria> {

	public CategoriaDao(EntityManager eM) {
		super(eM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Categoria> getTypeClass() {
		// TODO Auto-generated method stub
		return Categoria.class;
	}
	
}
