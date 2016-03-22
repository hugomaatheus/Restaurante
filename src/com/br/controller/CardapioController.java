package com.br.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.dao.CardapioDao;
import com.br.dao.CategoriaDao;
import com.br.model.Cardapio;
import com.br.model.Categoria;

public class CardapioController extends AbstractController {
	
	
	//Manter Cardapio
	public void cadastrarCardapio(Cardapio c) {
		EntityManager eM = factory.createEntityManager();
		CardapioDao cDao = new CardapioDao(eM);
		
		try {
			cDao.save(c);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public void removerCardapio(Long id) {
		EntityManager eM = factory.createEntityManager();
		CardapioDao cDao = new CardapioDao(eM);
		Cardapio c;
		
		try {
			c = cDao.getById(id);
			cDao.delete(c);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public void atualizarCardapio(Cardapio c) {
		EntityManager eM = factory.createEntityManager();
		CardapioDao cDao = new CardapioDao(eM);
		
		try {
			cDao.update(c);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	
	public List<Cardapio> listarCardapio() {
		EntityManager eM = factory.createEntityManager();
		Query query = eM.createNamedQuery("findAllCardapios");
		List<Cardapio> cardapios = query.getResultList();
		
		return cardapios;
	}
	
	public Cardapio buscarCardapio(Long id) {
		EntityManager eM = factory.createEntityManager();
		CardapioDao cDao = new CardapioDao(eM);
		Cardapio c = null;
		
		try {
			c = cDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
		return c;
	}
	/////////////////////////////////////////
	
	
	public Categoria buscarCategoria(Long id) {
		EntityManager eM = factory.createEntityManager();
		CategoriaDao cDao = new CategoriaDao(eM);
		Categoria c = null;
		
		try {
			c = cDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
		return c;
	}
	
}
