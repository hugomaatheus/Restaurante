package com.br.controller;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.br.dao.ClienteDao;
import com.br.model.Cliente;
import com.br.model.Delivery;
import com.br.model.Status;


public class ClienteController implements UsuarioController<Cliente>{

	private DeliveryController dController;

	@Override
	public void cadastrarUsuario(Cliente cliente) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		ClienteDao clienteDao = new ClienteDao(eM);
		
		try {
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
	public void desativarUsuario(Cliente cliente) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		ClienteDao clienteDao = new ClienteDao(eM);
		
		try {
			
			if(cliente.getStatus() == Status.ATIVO) {
				cliente.setStatus(Status.INATIVO);
				clienteDao.update(cliente);
				eM.getTransaction().begin();
				eM.getTransaction().commit();
			}
			else
				JOptionPane.showConfirmDialog(null, "Você está tentando desativar"
						+ "um cliente já inativo");
				
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
		
	}

	@Override
	public void atualizarUsuario(Cliente cliente) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		ClienteDao clienteDao = new ClienteDao(eM);
		
		try {
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
	public Cliente buscarUsuario(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		ClienteDao clienteDao = new ClienteDao(eM);
		Cliente c = null;
		
		try {
			c = clienteDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
		return c;
	}
	
	
	public Delivery buscarPedidoDelivery(Long id) {
		
		Delivery d = null;
		
		d = dController.buscarPedido(id);
		
		return d;
	}
	
	
	public void cadastrarPedido(Delivery delivery) {
		
		dController.cadastrarPedido(delivery);
		
	}

}
