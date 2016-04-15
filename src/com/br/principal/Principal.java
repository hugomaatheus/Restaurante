package com.br.principal;

import java.io.IOException;

import com.br.controller.FuncionarioController;
import com.br.controller.GerenteController;
import com.br.model.Funcionario;
import com.br.model.Mesa;




public class Principal {
	
	public static void main(String[] args) throws IOException {

		
		//Testando cliente
//		ClienteController cC = new ClienteController();
//		Endereco endereco = new Endereco("Moises Coelho", "Torre", "365", "Centro", "324234");
//		Cliente cliente = new Cliente("hugomaatheus123", "1234", "hugo@gmail.com", "Hugo Matheus Freire de Lima", endereco);
//		Cliente cliente = new Cliente();
//		Pedido d = new Delivery();
//		cliente = cC.buscarUsuario(3L); OK
//		cliente.setLogin("hugo_maatheus");
//		cC.atualizarUsuario(cliente); - OK
//		cC.cadastrarUsuario(cliente); - OK
//		cC.desativarUsuario(2L); - OK
//		cC.cadastrarPedidoDelivery(cliente);
//		d = cC.buscarPedidoDelivery(28L); OK
//		System.out.println(d.toString());
		
		//Testando FuncionarioController		
//		FuncionarioController fC = new FuncionarioController();
//		GerenteController gC = new GerenteController();
//		Cardapio c = new Cardapio();
//		Funcionario f = new Funcionario();
//		f = fC.buscarUsuario(7L);
//		f.setNome("Matheus");
//		Endereco e = new Endereco("Duque de Caxias", "Bessa", "27", "Centro", "213213");
//		Funcionario f = new Funcionario(800.00, "4234234", "Segurança", "Eriberto",
//				"hsdasjdas", "12323", e);
//		Pedido t = new Tradicional();
//		f = fC.buscarUsuario(1L);
//		Mesa m = new Mesa();
//		m = gC.buscarMesa(1L);
//		Reserva r = new Reserva(3, f.getNome());
//		Reserva r = new Reserva();
//		r = fC.buscarReserva(1L);
//		r.setStatus(Status.CANCELADO);
//		fC.cadastrarReserva(r, f); OK
//		r = fC.buscarReserva(1L); OK
//		fC.atualizarReserva(r); OK
//		fC.cancelarReserva(2L);
//		System.out.println(r.toString());
//		fC.cadastrarPedidoTradicional(m, f);
//		m = fC.buscarMesaTradicional(24L); OK
//		System.out.println(m.toString());
//		t = fC.buscarPedidoTradicional(27L); OK
//		System.out.println(t.toString());
//		fC.cancelarPedidoTradicional(27L); - OK
//		fC.cadastrarUsuario(f); - OK
//		fC.atualizarUsuario(f); - OK
//		c = fC.buscarCardapio(2L);
//		System.out.println(c.toString());
		
		
		//Testando GerenteController
//		GerenteController gC = new GerenteController();
//		Endereco e = new Endereco("Duque de Caxias", "Torre", "27", "Centro", "213213");
//		Funcionario f = new Funcionario(800.00, "4234234", "Cozinheiro", "Eriberto",
//				"hsdasjdas", "12323", e);
//		Funcionario f = new Funcionario();
//		f = gC.buscarUsuario(1L); OK
//		f.setNome("Matheus");
//		Reserva r = new Reserva(3, f.getNome());
//		Mesa m = new Mesa(1, 5);
//		Mesa m = new Mesa();
//		m = gC.buscarMesa(2L);
//		m.setStatus(Status.LIVRE);
//		System.out.println(m.toString());
//		Cardapio c = new Cardapio();
//		c = gC.buscarCardapio(2L); OK
//		gC.cadastrarMesa(f); OK
//		gC.cadastrarUsuario(f); OK
//		gC.atualizarUsuario(f); OK
//		gC.atualizarMesa(m); OK
//		gC.excluirMesa(6L); OK
//		gC.excluirUsuario(4L);
	
		
	}
}
