package com.br.controller;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.br.dao.ReservaDao;
import com.br.model.Reserva;
import com.br.model.Status;

public class ReservaController extends AbstractController {
	
	public static void cadastrarReserva(Reserva reserva) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			ReservaDao reservaDao = new ReservaDao(eM);
			reserva.setStatus(Status.ATIVO);
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
	
	public static void cancelarReserva(Long id) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		ReservaDao reservaDao = new ReservaDao(eM);
		Reserva reserva = reservaDao.getById(id);
		
		try {
			if(reserva.getStatus() == Status.ATIVO)
				reserva.setStatus(Status.CANCELADO);
			else
				JOptionPane.showMessageDialog(null, "Você está tentando cancelar "
						+ "uma reserva já cancelada!");
			
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
