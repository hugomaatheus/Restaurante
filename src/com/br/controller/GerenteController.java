package com.br.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.br.dao.CardapioDao;
import com.br.dao.CategoriaDao;
import com.br.dao.FuncionarioDao;
import com.br.dao.MesaDao;
import com.br.dao.PedidoDao;
import com.br.dao.ReservaDao;
import com.br.model.Cardapio;
import com.br.model.Categoria;
import com.br.model.Funcionario;
import com.br.model.ItemPedido;
import com.br.model.Mesa;
import com.br.model.Pedido;
import com.br.model.Reserva;
import com.br.util.Status;

public class GerenteController extends FuncionarioController implements UsuarioController<Funcionario> {
	

	
	//Manter Cardapio
	//OK
	public void cadastrarCardapio(Cardapio c, Categoria categoria) {
		EntityManager eM = factory.createEntityManager();
		CardapioDao cDao = new CardapioDao(eM);
		try {
			c.setCategoria(categoria);
			System.out.println(c.toString());
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
	
	public void consultarCardapio() {
		EntityManager eM = AbstractController.factory.createEntityManager();
		Query query = eM.createNamedQuery("findAllCardapios");
		List<Cardapio> cardapios = query.getResultList();
		
			System.out.println(cardapios.toString());
	}
	
	//OK
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
	
	//OK
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
	
	
	//Manter Categoria - OK
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
	
	//OK
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
	
	//OK
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
			eM.close();
		}
	}
	
	//OK
	public Categoria consultarCategoria(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		CategoriaDao cDao = new CategoriaDao(eM);
		Categoria c = new Categoria();
		
		try {
			c = cDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
		
		return c;
	}
	/////////////////////////////////////////////
	
	
	//OK
	public void cadastrarMesaReserva(Funcionario f, Reserva r, Mesa m, 
			Cardapio cardapio) {
		
		EntityManager eM = AbstractController.factory.createEntityManager();
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		ReservaDao rDao = new ReservaDao(eM);
		MesaDao mDao = new MesaDao(eM);
				
		try {			
			r.setDataInicial(data);
			r.setNome_Responsavel(f.getNome());
			r.setFuncionario(f);
			r.setStatus(Status.ATIVO);
			
			rDao.save(r);

			m.setStatus(Status.OCUPADA);
			mDao.save(m);
			
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
	
	//OK
	public Mesa buscarMesa(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		MesaDao mesaDao = new MesaDao(eM);
		Mesa m = new Mesa();
		
		try {
			m = mesaDao.getById(id);
		}catch (Exception e) {
			eM.getTransaction().rollback();
		}
			return m;
	}
	
	//OK
	public void excluirMesa(Long id) {
		EntityManager eM = AbstractController.factory.createEntityManager();
		MesaDao mesaDao = new MesaDao(eM);
		Mesa m = mesaDao.getById(id);
//		Query query = eM.createNamedQuery("fecharMesa");
		
		try {
//			query.setParameter("id", id);
//			query.executeUpdate();
			mesaDao.delete(m);
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
	
	//OK
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

//	@Override
//	public void desativarUsuario(Long id) {
//		
//	}
	
	//Violando fk na tabela Reserva
	//Criar consulta que deixe nulo a fk da reserva que aquele funcionario fez
	public void excluirUsuario(Long id) {
		EntityManager eM = factory.createEntityManager();
		FuncionarioDao fDao = new FuncionarioDao(eM);
		Funcionario f = fDao.getById(id);
		
		try{
			
			fDao.delete(f);
			eM.getTransaction().begin();
			eM.getTransaction().commit();
		}catch(Exception e) {
			eM.getTransaction().rollback();
		}
		finally {
			eM.close();
		}
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

}
