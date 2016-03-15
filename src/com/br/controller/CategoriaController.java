package com.br.controller;

import javax.persistence.EntityManager;

import com.br.dao.CategoriaDao;
import com.br.model.Categoria;

public class CategoriaController extends AbstractController {
	
	public static void cadastrarCategoria(Categoria categoria) {
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
	
	public static void removerCategoria(Categoria categoria) {
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
	
	public static Categoria buscarCategoria(Categoria categoria) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			CategoriaDao categoriaDao = new CategoriaDao(eM);
			categoriaDao.getById(categoria.getId());
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
		return null;
	}
	
	
}
