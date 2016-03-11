package com.br.Service;

import javax.persistence.EntityManager;

import com.br.dao.ClienteDao;
import com.br.model.Cliente;


public class ClienteController extends AbstractController {
	
	//Cadastrar Cliente
	public static void cadastrarCliente(Cliente cliente) {
		EntityManager eM = factory.createEntityManager();
		
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
		EntityManager eM = factory.createEntityManager();
		
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
	public static void buscarCliente(Cliente cliente) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			ClienteDao clienteDao = new ClienteDao(eM);
			clienteDao.getById(cliente.getId());
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
	}
	
	
	
	
	
}
