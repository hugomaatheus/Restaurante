package com.br.Service;

import javax.persistence.EntityManager;

import com.br.dao.ClienteDao;
import com.br.model.Cliente;


public class ClienteService extends AbstractService {
	
	public static void save(Cliente cliente) {
		EntityManager eM = factory.createEntityManager();
		
		try {
			ClienteDao clienteDao = new ClienteDao(eM);
			clienteDao.save(cliente);
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
