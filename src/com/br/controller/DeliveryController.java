package com.br.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.DeliveryDao;
import com.br.model.Delivery;

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
	public void buscarVendedor(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buscarPedido(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Delivery> listarItensPedido() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public double trocoPara(double valor) {		
//		return valor;
//	}
	
}
