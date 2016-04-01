package com.br.principal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.br.controller.FuncionarioController;
import com.br.controller.GerenteController;
import com.br.model.Cardapio;
import com.br.model.Funcionario;
import com.br.model.ItemPedido;
import com.br.model.Mesa;
import com.br.model.Pedido;
import com.br.model.Reserva;
import com.br.model.Tradicional;
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
//		FuncionarioController fC = new FuncionarioController();
//		Reserva r = new Reserva();
//		Funcionario f = new Funcionario();
//		Mesa m = new Mesa();
//		Tradicional t = new Tradicional();
//		ItemPedido i = new ItemPedido();
//		Cardapio c = new Cardapio();
//		Pedido p = new Pedido();
//		
//		f.setNome("Matheus Freire");
//		f.setStatus(Status.ATIVO);
//		f.setCargo("Atendente");
//		f.setCpf("3529842");
//		r.setNum_pessoa(4);
//		r.setNome_Responsavel("Hugo Matheus");
//		fC.cadastrarReserva(r, f);
//		r = fC.buscarReserva(2L);
//		r.setNome_Responsavel("Matheus");
//		fC.atualizarReserva(r);
//		fC.cancelarReserva(r.getId());
//		System.out.println(r);
//		c = fC.buscarCardapio(2L);
//		f = fC.buscarUsuario(2L);
//		Collection<ItemPedido> itens = new ArrayList<>();
//		p.setStatus(Status.PENDENTE);
//		p.setVendedor(f);
//		i.setQtd(2);
//		i.setPedido(p);
//		i.setCardapio(c);
//		itens.add(i);
//		p.setItens(itens);
//		t.setStatus(Status.ATIVO);
//		Collection<Tradicional> tradicionais = new ArrayList<>();
//		tradicionais.add(t);
//		m.setCapacidade(4);
//		m.setNumero(3);
//		m.setTradicionais(tradicionais);
//		t.setMesa(m);
//		fC.cadastrarPedidoTradicional(t, p, i, m, f, c);
		
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
//		gC.cadastrarCardapio(c, categoria);
//		gC.consultarCardapio(2L);
//		gC.atualizarCardapio(c);
//		gC.excluirCardapio(4L);
//		gC.atualizarCategoria(categoria);
//		gC.excluirCategoria(3L);
//		categoria = gC.consultarCategoria(2L);
//		System.out.println(categoria);
		
		
		
	}
}
