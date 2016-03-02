package com.br.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

@SuppressWarnings("unchecked")
public class AbstractDao <T extends AbstractEntity> {
	
	private EntityManager eM;
	
	public AbstractDao(EntityManager eM) {
		this.eM = eM;
	}
	
//	public T getById(T entity) {
//		return (T)eM.find(getTypeClass(), id);
//	}
	
	public void save(T entity) {
		eM.persist(entity);
	}
	
	public void update(T entity) {
		eM.merge(entity);
	}
	
	public void delete(T entity) {
		
	}
	
//	public List<T> findAll() {
//		return eM.createQuery(("FROM " + getTypeClass().getName())).getResultlist();
//	}

	private Class<?> getTypeClass() {
		Class<?> c = (Class<?>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		return c;
	}
	
	
}
