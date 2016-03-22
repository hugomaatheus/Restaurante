package com.br.controller;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.br.dao.FuncionarioDao;
import com.br.dao.TradicionalDao;
import com.br.model.Funcionario;
import com.br.model.Reserva;
import com.br.model.Status;
import com.br.model.Tradicional;

public class FuncionarioController extends UsuarioController {
	
	private TradicionalController tController;
	private ReservaController rController;
	private DeliveryController dController;
	
	
	public void cadastrarReserva(Reserva reserva) {
		rController.cadastrarReserva(reserva);
	}
	
	//buscarReserva()

	
	
	public void atualizarReserva(Reserva reserva) {
		rController.atualizarReserva(reserva);
	}
	
	public void cancelarReserva(Long id) {
		rController.cancelarReserva(id);
	}
	
	//buscarPedidoTradicional()
	//buscarPedidoDelivery()
	
	
	public void cadastrarPedidoTradicional(Tradicional tradicional) {
		tController.cadastrarPedido(tradicional);
	}
	
	public void cancelarPedidoTradicional(Long id) {
		EntityManager eM = factory.createEntityManager();
		TradicionalDao tDao = new TradicionalDao(eM);
		Tradicional tradicional = tController.buscarPedido(id);
		
		try {
			if(tradicional.getStatus() == Status.ATIVO)
				tradicional.setStatus(Status.CANCELADO);
			else
				JOptionPane.showMessageDialog(null, "Você está tentando cancelar "
						+ "uma reserva já cancelada!");
			
			tDao.update(tradicional);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	//atualizarPedidoTradicional()
	
	
	public void cadastrarFuncionario(Funcionario funcionario) {
		EntityManager eM = factory.createEntityManager();
		FuncionarioDao fDao = new FuncionarioDao(eM);
		
		try {
			fDao.save(funcionario);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	
	public Funcionario buscarFuncionario(Long id) {
		EntityManager eM = factory.createEntityManager();
		Funcionario f = null;
		FuncionarioDao fDao = new FuncionarioDao(eM);
		
		try {
			f = fDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
		return f;
	}
	
	public void atualizarFuncionario(Funcionario funcionario) {
		EntityManager eM = factory.createEntityManager();
		FuncionarioDao fDao = new FuncionarioDao(eM);
		
		try {
			fDao.update(funcionario);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	
	public void excluirFuncionario(Long id) {
		EntityManager eM = factory.createEntityManager();
		FuncionarioDao fDao = new FuncionarioDao(eM);
		Funcionario f = null;
		
		try {
			f = fDao.getById(id);
			fDao.delete(f);
		}catch (Exception e) {
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}
		finally {
			eM.close();
		}
	}
}
