package com.br.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.br.util.Status;

@Entity
//@SequenceGenerator(name="tradicional_id", sequenceName="tradicional_seq")
@Table(name="tradicional")
@PrimaryKeyJoinColumn(name="pedido_id")
public class Tradicional extends Pedido {
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_funcionario")
	private Funcionario vendedor;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mesa_id")
	private Mesa mesa;
	
	
	public Tradicional(Status status, Collection<ItemPedido> itens, Funcionario vendedor, Mesa mesa) {
		super();
		this.vendedor = vendedor;
		this.mesa = mesa;
	}
	
	public Tradicional() {}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("Mesa: %d %d %d", getMesa().getNumero(), getMesa().getId(), getId());
	}

}
