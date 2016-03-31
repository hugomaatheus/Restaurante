package com.br.principal;

import java.io.IOException;

import com.br.controller.GerenteController;
import com.br.model.Cardapio;
import com.br.model.Categoria;




public class Principal {
	
	public static void main(String[] args) throws IOException {

		
		//Testando cliente
//		ClienteController cC = new ClienteController();
//		Cliente c = new Cliente();
//		Endereco e = new Endereco();
//		Delivery d = new Delivery();
//		e.setRua("Duque de Caxias");
//		e.setBairro("Centro");
//		e.setComplemento("nenhum");
//		e.setTelefone("24332523");
//		e.setNumero("27");
//		c.setNome("Hugo");
//		c.setLogin("hugomatheus");
//		c.setEmail("hugomatheus650@gmail.com");
//		c.setSenha("1234");
//		c.setStatus(Status.ATIVO);
//		c.setEndereco(e);
//		d.setCliente(c);
//		d.setTrocoPara(20.00);
//		cC.cadastrarPedido(d);
//		cC.cadastrarUsuario(c);
		
		//Testando FuncionarioController		
//		FuncionarioController fC = new FuncionarioController();
//		Reserva r = new Reserva();
//		Funcionario f = new Funcionario();
//		
//		f.setNome("Matheus");
//		f.setStatus(Status.ATIVO);
//		f.setCargo("Atendente");
//		f.setCpf("33729842");
//		r.setNum_pessoa(4);
//		r.setNome_Responsavel("Hugo");
//		r.setFuncionario(f);
//		fC.cadastrarUsuario(f);
//		fC.cadastrarReserva(r);
		
		//Testando GerenteController
		GerenteController gC = new GerenteController();
//		Cardapio c = new Cardapio();
//		Categoria categoria = new Categoria();
		
//		categoria.setNome("Bebidas");
//		c.setNome("Logan 12 anos");
//		c.setCategoria(categoria);
//		c.setPreco(120.00);
//		gC.cadastrarCardapio(c);
		gC.consultarCardapio(2L);
	}
}
