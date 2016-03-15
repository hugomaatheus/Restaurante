package com.br.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Funcionario extends Usuario {	
	
	@Column(nullable=false)
	private double salario;
	
	@Column(nullable=false)
	private String cpf;
	
	private String cargo;
	

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		salario = salario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
