package com.br.controller;

public interface UsuarioController <T> {
	
	public void cadastrarUsuario(T entity);
	public void desativarUsuario(Long id);
	public void atualizarUsuario(T entity);
	public T buscarUsuario(Long id);
	
}
