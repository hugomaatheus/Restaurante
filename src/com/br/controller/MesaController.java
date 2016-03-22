package com.br.controller;

import javax.persistence.EntityManager;

import com.br.dao.MesaDao;
import com.br.model.Mesa;
import com.br.model.Reserva;

public class MesaController extends AbstractController {
	
	ReservaController rController;
	
	public void cadastrarMesa(Mesa mesa) {
		
		EntityManager eM = factory.createEntityManager();
		MesaDao mesaDao = new MesaDao(eM);
		
		try {
			mesaDao.save(mesa);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public void atualizarMesa(Mesa mesa) {
		EntityManager eM = factory.createEntityManager();
		MesaDao mesaDao = new MesaDao(eM);
		
		try {
			mesaDao.update(mesa);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public Mesa buscarMesa(Long id) {
		EntityManager eM = factory.createEntityManager();
		Mesa m = null;
		
		try {
			MesaDao mesaDao = new MesaDao(eM);
			m = mesaDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		return m;
		
	}
	
	public Reserva buscarReserva(Long id) {
		Reserva r = null;
		
		r = rController.buscarReserva(id);
		
		return r;
		
	}
	
	
}
