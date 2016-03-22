package com.br.principal;

import java.io.IOException;

import com.br.controller.FuncionarioController;
import com.br.model.Mesa;
import com.br.model.Tradicional;


public class Principal {
	
	public static void main(String[] args) throws IOException {

		
		
//		f.setNome("Hugo");
//		f.setCargo("garçom");
//		f.setCpf("34235235");
//		f.setStatus(Status.ATIVO);
//		fC.cadastrarUsuario(f);
		
		Mesa mesa = new Mesa();
		Tradicional t = new Tradicional();
		FuncionarioController fC = new FuncionarioController();
		
		mesa.setNumero(1);
		t.setMesa(mesa);
		fC.cadastrarPedidoTradicional(t);
		//JOptionPane.showMessageDialog(null, t.toString());
		
	}
}
