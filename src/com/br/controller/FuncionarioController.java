package com.br.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

import com.br.dao.CardapioDao;
import com.br.dao.DeliveryDao;
import com.br.dao.FuncionarioDao;
import com.br.dao.ItemPedidoDao;
import com.br.dao.PedidoDao;
import com.br.dao.ReservaDao;
import com.br.dao.TradicionalDao;
import com.br.model.Cardapio;
import com.br.model.Delivery;
import com.br.model.Funcionario;
import com.br.model.ItemPedido;
import com.br.model.Mesa;
import com.br.model.Pedido;
import com.br.model.Reserva;
import com.br.model.Tradicional;
import com.br.util.Status;

public class FuncionarioController extends AbstractController implements UsuarioController <Funcionario> {
	
	
	
	//Manter Reserva - OK
	public void cadastrarReserva(Reserva reserva, Funcionario f) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		ReservaDao reservaDao = new ReservaDao(eM);
		
		try {
			reserva.setStatus(Status.ATIVO);
			reserva.setDataInicial(data);
			reserva.setFuncionario(f);
			reservaDao.update(reserva);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	//OK
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
	
	//OK
	public void atualizarReserva(Reserva reserva) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		ReservaDao reservaDao = new ReservaDao(eM);
		
		try {
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
	
	//OK
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
	//Buscar mesa do pedido tradicional OK
	public Mesa buscarMesaTradicional(Long id) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		Mesa m = null;
		try {
			TradicionalDao tradicionalDao = new TradicionalDao(eM);
			Tradicional t =  (Tradicional) tradicionalDao.getById(id);
			m = t.getMesa();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
		return m;
	}
	
	//Problema com tabelas que estão mapeando as listas
	public void cadastrarPedidoTradicional(Mesa m, Funcionario f) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		TradicionalDao tradicionalDao = new TradicionalDao(eM);
		PedidoDao pDao = new PedidoDao(eM);
		CardapioDao cDao = new CardapioDao(eM);
		ItemPedidoDao iDao = new ItemPedidoDao(eM);
		
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		
		Collection<ItemPedido> itens = new ArrayList<>();
		Cardapio cardapio = new Cardapio();

		try {
			
			//Pessoas demais para a mesa
			if(m.getCapacidade() < m.getNumero())
				throw new Exception("Número de pessoas na mesa excede a capacidade da mesa!");

			else {
				cardapio = cDao.getById(2L);
				
				m.setStatus(Status.OCUPADA);
				
				Tradicional t = new Tradicional(Status.ANDAMENTO, itens, f, m);
				t.setData(data);
				
				
				Pedido p = new Pedido();
				ItemPedido i = new ItemPedido(2, cardapio);
				p.setData(data);
				p.setStatus(Status.ANDAMENTO);
				i.setPedido(p);
				i.setCardapio(cardapio);
				
				for (Iterator<ItemPedido> iterator = itens.iterator(); iterator.hasNext();) {
					if(!(i.getId() == null)) {
						itens.add(i);
					}
				}
				
				p.setItens(itens);
				
				iDao.save(i);
				pDao.update(p);
				tradicionalDao.update(t);
				eM.getTransaction().begin();
				eM.getTransaction().commit();
			}
			

		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	//Buscar pedido tradicional - OK
	public Pedido buscarPedidoTradicional(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		TradicionalDao tDao = new TradicionalDao(eM);
		Pedido t = null;
		
		try {
			t =  tDao.getById(id);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			eM.getTransaction().rollback();
		}
		
		return t;
	}
	
	//OK
	public void cancelarPedidoTradicional(Long id) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		TradicionalDao tDao = new TradicionalDao(eM);
		Pedido tradicional = (Tradicional) tDao.getById(id);
		
		try {
			if(tradicional.getStatus() == Status.ATIVO || tradicional.getStatus() == null)
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
	
	
	//Manter Funcionario - OK
	@Override
	public void cadastrarUsuario(Funcionario f) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		FuncionarioDao fDao = new FuncionarioDao(eM);
		
		try {
			f.setStatus(Status.ATIVO);
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
	
	//OK
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
	
	//OK
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
	//OK
	public Cardapio buscarCardapio(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		CardapioDao cDao = new CardapioDao(eM);
		Cardapio c = new Cardapio();
		
		try {
			c = cDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
		return c;
	}
	
}
