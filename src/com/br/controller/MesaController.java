package com.br.controller;

import javax.persistence.EntityManager;

import com.br.dao.MesaDao;
import com.br.dao.ReservaDao;
import com.br.model.Mesa;
import com.br.model.Reserva;

public class MesaController extends AbstractController {
	
	public static void cadastrarMesa(Mesa mesa) {
		
		EntityManager eM = factory.createEntityManager();
		
		try {
			MesaDao mesaDao = new MesaDao(eM);
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
	
	public static Mesa buscarMesa(Long id) {
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
	
	public static Reserva buscarReserva(Reserva reserva) {
		EntityManager eM = factory.createEntityManager();
		Reserva r = null;
		
		try {
			ReservaDao reservaDao = new ReservaDao(eM);
			r = reservaDao.getById(reserva.getId());
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		return r;
		
	}
	
	
}
