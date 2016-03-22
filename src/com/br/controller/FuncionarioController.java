package com.br.controller;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.br.dao.FuncionarioDao;
import com.br.dao.TradicionalDao;
import com.br.model.Delivery;
import com.br.model.Funcionario;
import com.br.model.Reserva;
import com.br.model.Status;
import com.br.model.Tradicional;

public class FuncionarioController implements UsuarioController <Funcionario> {
	
	private TradicionalController tController;
	private ReservaController rController;
	private DeliveryController dController;
	
	//Manter Reserva
	public void cadastrarReserva(Reserva reserva) {
		rController.cadastrarReserva(reserva);
	}
	
	public Reserva buscarReserva(Long id) {
		return rController.buscarReserva(id);
	}
	
	public void atualizarReserva(Reserva reserva) {
		rController.atualizarReserva(reserva);
	}
	
	public void cancelarReserva(Long id) {
		rController.cancelarReserva(id);
	}
	///////////////////////////////////////////
	
	
	//Manter Pedido Tradicional
	public Tradicional buscarPedidoTradicional(Long id) {
		return tController.buscarPedido(id);
	}
	
	public void cadastrarPedidoTradicional(Tradicional tradicional) {
		tController.cadastrarPedido(tradicional);
	}
	
	public void cancelarPedidoTradicional(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
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
	///////////////////////////////////////////
	
	
	public Delivery buscarPedidoDelivery(Long id) {
		return dController.buscarPedido(id);
	}
	
	
	//Manter Funcionario
	@Override
	public void cadastrarUsuario(Funcionario f) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		FuncionarioDao fDao = new FuncionarioDao(eM);
		
		try {
			fDao.save(f);
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
	public void desativarUsuario(Funcionario f) {
		//Funcionario não desativa funcionario
	}
	
	
	@Override
	public void atualizarUsuario(Funcionario f) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		FuncionarioDao fDao = new FuncionarioDao(eM);
		
		try {
			fDao.update(f);
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
	public Funcionario buscarUsuario(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		FuncionarioDao fDao = new FuncionarioDao(eM);
		Funcionario f = null;
		
		try {
			f = fDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
		return f;
	}
	///////////////////////////////////////////
	
}
