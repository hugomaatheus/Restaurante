package com.br.controller;

import javax.persistence.EntityManager;

import com.br.dao.CategoriaDao;
import com.br.model.Categoria;

public class CategoriaController extends AbstractController {
	
	public void cadastrarCategoria(Categoria categoria) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			CategoriaDao categoriaDao = new CategoriaDao(eM);
			categoriaDao.save(categoria);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public void removerCategoria(Categoria categoria) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			CategoriaDao categoriaDao = new CategoriaDao(eM);
			categoriaDao.delete(categoria);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.getTransaction().rollback();
		}
	}
	
	public Categoria buscarCategoria(Long id) {
		EntityManager eM = factory.createEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(eM);
		Categoria c = null;
		
		try {	
			c = categoriaDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
		return c;
	}
	
	public void atualizarCategoria(Categoria c) {
		EntityManager eM = factory.createEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(eM);
		
		 try {
			 categoriaDao.update(c);
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
