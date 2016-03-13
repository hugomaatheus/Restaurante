package com.br.controller;

import javax.persistence.EntityManager;

import com.br.dao.ReservaDao;
import com.br.model.Reserva;

public class ReservaController extends AbstractController {
	
	public static void cadastrarReserva(Reserva reserva) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			ReservaDao reservaDao = new ReservaDao(eM);
			reservaDao.save(reserva);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public static void buscarReserva(Long id) {
		
		EntityManager eM = factory.createEntityManager();
		
		try {
			ReservaDao reservaDao = new ReservaDao(eM);
			reservaDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
	}
	
	public static void atualizarReserva(Reserva reserva) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			ReservaDao reservaDao = new ReservaDao(eM);
			reservaDao.update(reserva);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public static void excluirReserva(Reserva reserva) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			ReservaDao reservaDao = new ReservaDao(eM);
			reservaDao.delete(reserva);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}

}
