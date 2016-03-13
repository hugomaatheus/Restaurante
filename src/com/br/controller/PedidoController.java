package com.br.controller;

import java.util.List;

public interface PedidoController<T> {
	
	public void cadastrarPedido(T entity);
	public void buscarVendedor(Long id);
	public void buscarPedido(Long id);
	public List<T> listarItensPedido();
	
}
