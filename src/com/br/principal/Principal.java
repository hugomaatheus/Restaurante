package com.br.principal;

import java.io.IOException;

import com.br.controller.CategoriaController;
import com.br.controller.ClienteController;
import com.br.controller.FuncionarioController;
import com.br.model.Categoria;
import com.br.model.Cliente;
import com.br.model.Endereco;
import com.br.model.Funcionario;
import com.br.model.Status;

public class Principal {
	
	public static void main(String[] args) throws IOException {

		
		Funcionario f = new Funcionario();
		FuncionarioController fC = new FuncionarioController();
		
		f.setNome("Hugo");
		f.setCargo("garçom");
		f.setCpf("34235235");
		f.setStatus(Status.ATIVO);
		fC.cadastrarUsuario(f);
		
	}
}
