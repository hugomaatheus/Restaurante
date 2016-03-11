package com.br.Service;

import java.util.List;

import com.br.model.ItemPedido;

public abstract class PedidoController<T> extends AbstractController {
	
	public void cadastrarPedido(T entity) {
		
	}
	
	public T buscarPedido(T entity) {
		return null;
	}
	
	public T buscarVendedor(T entity) {
		return null;
	}
	
	public List<ItemPedido> listarItensPedido() {
		return null;
	}
	
	@SuppressWarnings("null")
	public double totalDaCompra(ItemPedido itemPedido) {
		return (Double) null;
	}
	
	
}
