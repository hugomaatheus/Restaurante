package com.br.controller;

public interface UsuarioController<T> {
	
	public void cadastrarUsuario(T entity);
	public void desativarUsuario(T entity);
	public void atualizarUsuario(T entity);
	public T buscarUsuario(T entity);

}
