package com.br.Service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractService {
	
	protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("restaurante");

}
