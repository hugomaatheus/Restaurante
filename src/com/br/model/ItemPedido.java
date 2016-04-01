package com.br.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="itemPedido_id", sequenceName="itemPedido_seq")
@NamedQuery(name="findAllItens", query="SELECT i FROM ItemPedido i")
public class ItemPedido extends AbstractEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private int qtd;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_pedido")
	private Pedido pedido;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_cardapio")
	private Cardapio cardapio;

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	

}
