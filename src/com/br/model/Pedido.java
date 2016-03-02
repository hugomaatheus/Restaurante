package com.br.model;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.br.dao.AbstractEntity;

@Entity
@SequenceGenerator(name="pedido_id", sequenceName="pedido_seq")
public class Pedido extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false)
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(nullable=false)
	private String status;
	
	@OneToMany
	@JoinTable(name="pedido_itemCardapio", joinColumns=@JoinColumn(name="pedido_id"),
	inverseJoinColumns=@JoinColumn(name="itemCardapio_id"))
	private Collection<ItemCardapio> itens;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
