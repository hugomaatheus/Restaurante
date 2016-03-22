package com.br.principal;

import java.io.IOException;

import com.br.controller.ClienteController;
import com.br.model.Cliente;

public class Principal {
	
	public static void main(String[] args) throws IOException {

		
		Cliente c = new Cliente();
		ClienteController cC = new ClienteController();
		
		c.setNome("Hugo");
		c.setEmail("hugomatheus650@gmail.com");
		c.setSenha("23242");
		cC.cadastrarUsuario(c);
	}
}
