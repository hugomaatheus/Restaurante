package com.br.controller;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.br.dao.ReservaDao;
import com.br.model.Reserva;
import com.br.model.Status;

public class ReservaController extends AbstractController {
	
	public void cadastrarReserva(Reserva reserva) {
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
	
	public Reserva buscarReserva(Long id) {
		
		EntityManager eM = factory.createEntityManager();
		Reserva r = null;
		
		try {
			ReservaDao reservaDao = new ReservaDao(eM);
			r = reservaDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		return r;
	}
	
	public void atualizarReserva(Reserva reserva) {
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
	
	public void cancelarReserva(Long id) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		ReservaDao reservaDao = new ReservaDao(eM);
		Reserva reserva = reservaDao.getById(id);
		
		try {
			if(reserva.getStatus() == Status.ATIVO) {
				reserva.setStatus(Status.CANCELADO);
				reservaDao.update(reserva);
				eM.getTransaction().begin();
				eM.getTransaction().commit();
			}
				
			else
				JOptionPane.showMessageDialog(null, "Você está tentando cancelar "
						+ "uma reserva já cancelada!");
			
			
				
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public void excluirReserva(Reserva reserva) {
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
