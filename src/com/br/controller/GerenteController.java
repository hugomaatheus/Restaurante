package com.br.controller;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.dao.CardapioDao;
import com.br.dao.CategoriaDao;
import com.br.dao.FuncionarioDao;
import com.br.dao.MesaDao;
import com.br.dao.ReservaDao;
import com.br.model.Cardapio;
import com.br.model.Categoria;
import com.br.model.Funcionario;
import com.br.model.Mesa;
import com.br.model.Reserva;
import com.br.model.Tradicional;
import com.br.util.Status;

public class GerenteController extends FuncionarioController /*implements UsuarioController<Cliente>*/ {
	

	
	//Manter Cardapio
	public void cadastrarCardapio(Cardapio c, Categoria categoria) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		CardapioDao cDao = new CardapioDao(eM);

		try {
			c.setCategoria(categoria);
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
	
	public void consultarCardapio() {
		EntityManager eM = AbstractController.factory.createEntityManager();
		Query query = eM.createNamedQuery("findAllCardapios");
		List<Cardapio> cardapios = query.getResultList();
		
			System.out.println(cardapios.toString());
	}
	
	public void atualizarCardapio(Cardapio c) {
		EntityManager eM = AbstractController.factory.createEntityManager();
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
	
	public void excluirCardapio(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
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
	////////////////////////////////////////
	
	
	//Manter Categoria
	public void cadastrarCategoria(Categoria c) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(eM);
		
		try {
			categoriaDao.save(c);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public void atualizarCategoria(Categoria c) {
		EntityManager eM = AbstractController.factory.createEntityManager();
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
	
	public void excluirCategoria(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		CategoriaDao categoriaDao = new CategoriaDao(eM);
		Categoria c = new Categoria();
		
		c = consultarCategoria(id);
		
		try {
			categoriaDao.delete(c);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.getTransaction().rollback();
		}
	}
	
	public Categoria consultarCategoria(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		CategoriaDao cDao = new CategoriaDao(eM);
		Categoria c = null;
		
		try {
			c = cDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		
		return c;
	}
	/////////////////////////////////////////////
	
	
	//Manter mesa
	public void cadastrarMesa(Mesa m) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		MesaDao mesaDao = new MesaDao(eM);
		Collection<Tradicional> tradicionais = null;
		Collection<Reserva> reservas = null;
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
//		Tradicional t = new Tradicional();
		Reserva r = new Reserva();
		Funcionario f = new Funcionario();
		ReservaDao rDao = new ReservaDao(eM);
		FuncionarioDao fDao = new FuncionarioDao(eM);
		
		try {
			f.setNome("Matheus Freire");
			r.setDataInicial(data);
			r.setNome_Responsavel(f.getNome());
			r.setNum_pessoa(4);
			r.setStatus(Status.ATIVO);
			fDao.save(f);
			rDao.save(r);
			mesaDao.save(m);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public void atualizarMesa(Mesa m) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		MesaDao mesaDao = new MesaDao(eM);
		
		try {
			mesaDao.update(m);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
	}
	
	public void excluirMesa(Long id) {
		//TODO
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
