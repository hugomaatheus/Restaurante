package com.br.controller;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.br.dao.ClienteDao;
import com.br.dao.DeliveryDao;
import com.br.model.Cliente;
import com.br.model.Delivery;
import com.br.util.Status;


public class ClienteController implements UsuarioController<Cliente>{

	
	//Manter cliente
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
	public void desativarUsuario(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		ClienteDao clienteDao = new ClienteDao(eM);
		Cliente cliente = new Cliente();
		
		try {
			
			cliente = clienteDao.getById(id);
			
			if(cliente.getStatus() == Status.ATIVO) {
				cliente.setStatus(Status.INATIVO);
				clienteDao.update(cliente);
				eM.getTransaction().begin();
				eM.getTransaction().commit();
			}
			else
				JOptionPane.showConfirmDialog(null, "Voc� est� tentando desativar"
						+ " um cliente j� inativo");
				
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
	//////////////////////////////////////////
	
	
	//Manter pedido
	public Delivery buscarPedidoDelivery(Long id) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		Delivery d = null;

		try {
			DeliveryDao deliveryDao = new DeliveryDao(eM);
			d = (Delivery) deliveryDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}

		return d;	
	}
	
	
	public void cadastrarPedido(Delivery delivery) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		Cliente cliente = new Cliente();
		
		try {
			DeliveryDao deliveryDao = new DeliveryDao(eM);
			ClienteDao cDao = new ClienteDao(eM);
			Collection<Delivery> d = null;
			
			delivery.setStatus(Status.ANDAMENTO);
			delivery.setData(data);
			d.add(delivery);
			cliente.setDeliverys(d);
			deliveryDao.save(delivery);
			cDao.update(cliente);
			eM.getTransaction().begin();		
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
		
	}
	///////////////////////////////////////////
}
