package com.br.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.dao.DeliveryDao;
import com.br.dao.ItemPedidoDao;
import com.br.model.Delivery;
import com.br.model.Funcionario;
import com.br.model.ItemPedido;
import com.br.model.Pedido;

public class DeliveryController implements PedidoController<Delivery> {

	@Override
	public void cadastrarPedido(Delivery delivery) {
		new AbstractController();
		EntityManager eM = AbstractController.factory.createEntityManager();
		
		try {
			DeliveryDao deliveryDao = new DeliveryDao(eM);
			deliveryDao.save(delivery);
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
	public Funcionario buscarVendedor(Delivery delivery) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		Delivery d = null;
		
		try {
			DeliveryDao deliveryDao = new DeliveryDao(eM);
			d = (Delivery) deliveryDao.getById(delivery.getId());
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		return d.getVendedor();
		
	}

	@Override
	public Delivery buscarPedido(Long id) {
		
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


	@Override
	public List<ItemPedido> listarItensPedido() {
		
		return ItemPedidoController.listarItensPedido();
		
	}

	
}
