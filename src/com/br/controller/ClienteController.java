package com.br.controller;

import javax.persistence.EntityManager;

import com.br.dao.ClienteDao;
import com.br.model.Cliente;


public class ClienteController implements UsuarioController<Cliente> {
	
	//Cadastrar Cliente
	public void cadastrarUsuario(Cliente cliente) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		
		try {
			ClienteDao clienteDao = new ClienteDao(eM);
			clienteDao.save(cliente);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}

	@Override
	public void desativarUsuario(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarUsuario(Cliente cliente) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		
		try {
			ClienteDao clienteDao = new ClienteDao(eM);
			clienteDao.update(cliente);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
		
	}

	@Override
	public Cliente buscarUsuario(Cliente cliente) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		Cliente c = null;
		
		try {
			ClienteDao clienteDao = new ClienteDao(eM);
			c = clienteDao.getById(cliente.getId());
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		return c;
	}
	
	
	
	
	
}
