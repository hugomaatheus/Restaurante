package com.br.dao;

import javax.persistence.EntityManager;

import com.br.model.Funcionario;

public class FuncionarioDao extends AbstractDao<Funcionario> {

	public FuncionarioDao(EntityManager eM) {
		super(eM);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Funcionario> getTypeClass() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
