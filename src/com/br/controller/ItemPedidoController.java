package com.br.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.br.dao.CardapioDao;
import com.br.dao.ItemPedidoDao;
import com.br.dao.PedidoDao;
import com.br.model.Cardapio;
import com.br.model.ItemPedido;
import com.br.model.Pedido;

public class ItemPedidoController extends AbstractController {
	
	public static void cadastrarItemPedido(ItemPedido itemPedido) {
		
		EntityManager eM = factory.createEntityManager();
		
		try {
			ItemPedidoDao itemPedidoDao = new ItemPedidoDao(eM);
			itemPedidoDao.save(itemPedido);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
		
	}
	
	public static void cadastrarPedido(Pedido pedido) {
		
		EntityManager eM = factory.createEntityManager();
		
		try {
			PedidoDao pedidoDao = new PedidoDao(eM);
			pedidoDao.save(pedido);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
		
	}
	
	public static Cardapio cardapio(Long id) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			CardapioDao cardapioDao = new CardapioDao(eM);
			cardapioDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		return null;
	}
	
	public static List<ItemPedido> listarItensPedido() {
		EntityManager eM = factory.createEntityManager();
		
		try {
			ItemPedidoDao itemPedido = new ItemPedidoDao(eM);
			itemPedido.findAll();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		return null;
	}
	
//	public static double (Cardapio cardapio) {
//		
//	}
	
}
