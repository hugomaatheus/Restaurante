package com.br.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.TradicionalDao;
import com.br.model.Funcionario;
import com.br.model.ItemPedido;
import com.br.model.Tradicional;

public class TradicionalController implements PedidoController<Tradicional> {	
	
	//Manter pedido tradicional
	public void cadastrarPedido(Tradicional tradicional) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		TradicionalDao tradicionalDao = new TradicionalDao(eM);
		
		try {
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
	public Tradicional buscarPedido(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		Tradicional t = null;
		
		try {
			TradicionalDao tradicionalDao = new TradicionalDao(eM);
			t = (Tradicional) tradicionalDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
		return t;
	}
	///////////////////////////////////////////////////////////
	
	//Buscando vendedor daquele pedido
	@Override
	public Funcionario buscarVendedor(Tradicional tradicional) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		Tradicional t = null;
		
		try {
			TradicionalDao tradicionalDao = new TradicionalDao(eM);
			t = (Tradicional) tradicionalDao.getById(tradicional.getId());
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		return t.getVendedor();
	}


	@Override
	public List<ItemPedido> listarItensPedido() {
		
		return ItemPedidoController.listarItensPedido();
	}

	
}
