package com.br.controller;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.br.dao.DeliveryDao;
import com.br.dao.FuncionarioDao;
import com.br.dao.ItemPedidoDao;
import com.br.dao.ReservaDao;
import com.br.dao.TradicionalDao;
import com.br.model.Delivery;
import com.br.model.Funcionario;
import com.br.model.ItemPedido;
import com.br.model.Reserva;
import com.br.model.Tradicional;
import com.br.util.Status;

public class FuncionarioController implements UsuarioController <Funcionario> {
	
	
	//Manter Reserva
	public void cadastrarReserva(Reserva reserva, Funcionario f) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();

		try {
			ReservaDao reservaDao = new ReservaDao(eM);
			reserva.setStatus(Status.ATIVO);
			reserva.setDataInicial(data);
			reserva.setFuncionario(f);
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
		
		EntityManager eM = AbstractController.factory.createEntityManager();
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
		
		EntityManager eM = AbstractController.factory.createEntityManager();

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
			//Testa para caso esteja tentando cancelar uma reserva já cancelada
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
	///////////////////////////////////////////
	
	
	//Manter Pedido Tradicional
	public Tradicional buscarPedidoTradicional(Long id) {
		
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
	
	public void cadastrarPedidoTradicional(Tradicional tradicional) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		TradicionalDao tradicionalDao = new TradicionalDao(eM);
		ItemPedidoDao itemPedidoDao = new ItemPedidoDao(eM);

		try {

			tradicionalDao.save(tradicional);
			for (ItemPedido itemPedido: tradicional.getItens()) {
				if(itemPedido.getCardapio() == null) {
					throw new Exception("Item sem cardápio");
				}

				itemPedidoDao.save(itemPedido);
			}		

			eM.getTransaction().begin();
			eM.getTransaction().commit();

		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}	
	
	public void cancelarPedidoTradicional(Long id) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		TradicionalDao tDao = new TradicionalDao(eM);
		Tradicional tradicional = buscarPedidoTradicional(id);
		
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
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		Delivery d = null;

		try {
			DeliveryDao deliveryDao = new DeliveryDao(eM);
			d = (Delivery) deliveryDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}

		return d;
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
	public void desativarUsuario(Long id) {
		//Funcionario não desativa funcionario
		//Apenas o gerente!
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
