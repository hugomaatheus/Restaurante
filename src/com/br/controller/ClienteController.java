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
	
	//Atualizar Cliente
	public static void atualizarCliente(Cliente cliente) {
		
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
	
	//Buscar Cliente
	public static void buscarCliente(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		
		try {
			ClienteDao clienteDao = new ClienteDao(eM);
			clienteDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
	}

	@Override
	public void desativarUsuario(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarUsuario(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarUsuario(Cliente entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
}
