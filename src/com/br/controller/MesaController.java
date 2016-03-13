package com.br.controller;

import javax.persistence.EntityManager;

import com.br.dao.MesaDao;
import com.br.model.Mesa;

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
		
		try {
			MesaDao mesaDao = new MesaDao(eM);
			mesaDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		return null;
		
	}
	
	public static Mesa buscarReserva(Long id) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			MesaDao mesaDao = new MesaDao(eM);
			mesaDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		return null;
		
	}
	
	
}
