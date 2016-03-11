package com.br.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.br.model.AbstractEntity;

public abstract class AbstractDao <T extends AbstractEntity> {
	
	private EntityManager eM;
	
	public AbstractDao(EntityManager eM) {
		this.eM = eM;
	}
	
	public void save(T entity) {
		eM.persist(entity);
	}
	
	public void update(T entity) {
		eM.merge(entity);
	}
	
	public void delete(T entity) {
		entity = eM.find(getTypeClass(), entity.getId());
		eM.remove(entity);
	}
	
	public T getById(Long id) {
		return eM.find(getTypeClass(), id);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query query = eM.createQuery(("select e from " + getTypeClass().getSimpleName()) + " p");
		return query.getResultList();
	}

	public abstract Class<T> getTypeClass();
	
	
}
