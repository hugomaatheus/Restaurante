package com.br.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="reserva_id", sequenceName="reserva_seq")
public class Reserva extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private Date dataInicial;
	@Column(nullable=false)
	private Date dataFinal;
	@Column(nullable=false)
	private int num_pessoa;
	@Column(nullable=false)
	private String nome_Responsavel;
	
	private Status status;
	
	@Embedded
	private Funcionario funcionario;
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public int getNum_pessoa() {
		return num_pessoa;
	}
	public void setNum_pessoa(int num_pessoa) {
		this.num_pessoa = num_pessoa;
	}
	public String getNome_Responsavel() {
		return nome_Responsavel;
	}
	public void setNome_Responsavel(String nome_Responsavel) {
		this.nome_Responsavel = nome_Responsavel;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
