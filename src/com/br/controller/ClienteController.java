package com.br.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.br.dao.CardapioDao;
import com.br.dao.ClienteDao;
import com.br.dao.DeliveryDao;
import com.br.model.Cardapio;
import com.br.model.Cliente;
import com.br.model.Delivery;
import com.br.model.ItemPedido;
import com.br.util.Status;


public class ClienteController extends AbstractController implements UsuarioController<Cliente>{

	
	private Cardapio cardapio;


	//Manter cliente - OK
	@Override
	public void cadastrarUsuario(Cliente cliente) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		ClienteDao clienteDao = new ClienteDao(eM);
		
		try {	
			cliente.setStatus(Status.ATIVO);
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

	//OK
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
				JOptionPane.showConfirmDialog(null, "Você está tentando desativar"
						+ " um cliente já inativo");
				
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
		
	}
	
	//OK
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
	
	//OK
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
	
	
	//Manter pedido - OK
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
	
	//Faz pedido, porém problema com tabela do relacionamento
	public void cadastrarPedidoDelivery(Cliente cliente) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		DeliveryDao deliveryDao = new DeliveryDao(eM);
		ClienteDao cDao = new ClienteDao(eM);
		CardapioDao cardapioDao = new CardapioDao(eM);
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		cardapio = new Cardapio();
		Collection<Delivery> deliverys = new ArrayList<>();
		Collection<ItemPedido> itens = new ArrayList<>();
		
		try {
			
			cardapio = cardapioDao.getById(2L);
			Delivery delivery = new Delivery(50.00, cliente);			
			delivery.setStatus(Status.ANDAMENTO);
			delivery.setData(data);
			
			for (Iterator<Delivery> iterator = deliverys.iterator(); iterator.hasNext();) {
				deliverys.add(delivery);
			}
			
			ItemPedido i = new ItemPedido(2, cardapio);
			
			for (Iterator<ItemPedido> iterator = itens.iterator(); iterator.hasNext();) {
				itens.add(i);
			}
			
			cliente.setDeliverys(deliverys);
			delivery.setItens(itens);
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
