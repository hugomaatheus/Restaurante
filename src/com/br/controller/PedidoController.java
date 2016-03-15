package com.br.controller;

import java.util.List;

import com.br.model.Funcionario;
import com.br.model.ItemPedido;



public interface PedidoController<T> {
	
	public void cadastrarPedido(T entity);
	public Funcionario buscarVendedor(T entity);
	public T buscarPedido(T entity);
	public List<ItemPedido> listarItensPedido();
	
}
