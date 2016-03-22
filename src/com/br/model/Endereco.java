package com.br.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {
	
	
	private String rua;
	
	private String bairro;
	
	private String numero;
	
	private String complemento;
	
	private String telefone;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Rua: %s\n"
				+ "Número: %s\n"
				+ "Bairro: %s\n", getRua(), getNumero(), getBairro());
	}
	
}
