package com.br.controller;

import javax.persistence.EntityManager;

import com.br.dao.MesaDao;
import com.br.model.Cardapio;
import com.br.model.Categoria;
import com.br.model.Mesa;

public class GerenteController extends FuncionarioController /*implements UsuarioController<Cliente>*/ {
	
	FuncionarioController fController;
	CardapioController cardController;
	CategoriaController catController;
	MesaController mController;
	
	//Manter Cardapio
	public void cadastrarCardapio(Cardapio c) {
		cardController.cadastrarCardapio(c);
	}
	
	public Cardapio consultarCardapio(Long id) {
		return cardController.buscarCardapio(id);
	}
	
	public void atualizarCardapio(Cardapio c) {
		cardController.atualizarCardapio(c);
	}
	
	public void excluirCardapio(Long id) {
		cardController.removerCardapio(id);
	}
	////////////////////////////////////////
	
	
	//Manter Categoria
	public void cadastrarCategoria(Categoria c) {
		catController.cadastrarCategoria(c);
	}
	
	public void atualizarCategoria(Categoria c) {
		catController.atualizarCategoria(c);
	}
	
	public void excluirCategoria(Long id) {
		Categoria c;
		c = catController.buscarCategoria(id);
		catController.removerCategoria(c);
	}
	
	public Categoria consultarCategoria(Long id) {
		return catController.buscarCategoria(id);
	}
	/////////////////////////////////////////////
	
	
	//Manter mesa
	public void cadastrarMesa(Mesa m) {
		mController.cadastrarMesa(m);
	}
	
	public void atualizarMesa(Mesa m) {
		mController.atualizarMesa(m);
	}
	
	public void excluirMesa(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		MesaDao mDao = new MesaDao(eM);
		Mesa m;	
		m = mController.buscarMesa(id);
		
		try {
			mDao.delete(m);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	/////////////////////////////////////////////
	
//	@Override
//	public void cadastrarUsuario(T entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void desativarUsuario(T entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void atualizarUsuario(T entity) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public T buscarUsuario(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
