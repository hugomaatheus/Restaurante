package com.br.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractController {
	
	protected static EntityManagerFactory factory = Persistence.createEntityManagerFactory("restaurante");

}
