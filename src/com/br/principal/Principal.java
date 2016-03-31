package com.br.principal;

import java.io.IOException;

import com.br.controller.FuncionarioController;
import com.br.model.Funcionario;
import com.br.model.Reserva;
import com.br.util.Status;




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
		FuncionarioController fC = new FuncionarioController();
		Reserva r = new Reserva();
//		Funcionario f = new Funcionario();
//		
//		f.setNome("Matheus Freire");
//		f.setStatus(Status.ATIVO);
//		f.setCargo("Atendente");
//		f.setCpf("3529842");
//		r.setNum_pessoa(4);
//		r.setNome_Responsavel("Hugo");
//		fC.cadastrarReserva(r, f);
		r = fC.buscarReserva(1L);
		System.out.println(r);
		
		//Testando GerenteController
//		GerenteController gC = new GerenteController();
//		Cardapio c = new Cardapio();
//		Categoria categoria = new Categoria();
//		Mesa mesa = new Mesa();
//		categoria.setNome("Whisky");
//		c.setNome("Logan 12 anos");
//		c.setCategoria(categoria);
//		c.setPreco(130.00);
//		mesa.setCapacidade(4);
//		mesa.setNumero(2);
//		gC.cadastrarMesa(mesa);
//		gC.cadastrarCardapio(c);
//		gC.consultarCardapio(2L);
//		gC.atualizarCardapio(c);
//		gC.excluirCardapio(4L);
//		gC.atualizarCategoria(categoria);
//		gC.excluirCategoria(3L);
//		categoria = gC.consultarCategoria(2L);
//		System.out.println(categoria);
		
	}
}
