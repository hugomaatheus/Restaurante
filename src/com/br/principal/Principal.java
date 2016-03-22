package com.br.principal;

import java.io.IOException;

import com.br.controller.CategoriaController;
import com.br.controller.ClienteController;
import com.br.controller.FuncionarioController;
import com.br.model.Categoria;
import com.br.model.Cliente;
import com.br.model.Funcionario;

public class Principal {
	
	public static void main(String[] args) throws IOException {

		
		Categoria c = new Categoria();
		CategoriaController cC = new CategoriaController();
		
		c.setNome("Bebidas");
		cC.cadastrarCategoria(c);
	}
}
