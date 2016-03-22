package com.br.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="pedido_id", sequenceName="pedido_seq")
@Inheritance(strategy=InheritanceType.JOINED)
public class Pedido extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="fk_funcionario")
	private Funcionario vendedor;
	
	@OneToMany
	@JoinTable(name="pedido_itemCardapio", joinColumns=@JoinColumn(name="pedido_id"),
	inverseJoinColumns=@JoinColumn(name="itemCardapio_id"))
	private Collection<ItemPedido> itens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Collection<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Collection<ItemPedido> itens) {
		this.itens = itens;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}
	
	
}
