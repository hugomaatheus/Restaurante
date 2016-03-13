package com.br.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.TradicionalDao;
import com.br.model.Tradicional;

public class TradicionalController implements PedidoController<Tradicional> {	
	
	public void cadastrarPedido(Tradicional tradicional) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		
		try {
			TradicionalDao tradicionalDao = new TradicionalDao(eM);
			tradicionalDao.save(tradicional);
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
	public List<Tradicional> listarItensPedido() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
