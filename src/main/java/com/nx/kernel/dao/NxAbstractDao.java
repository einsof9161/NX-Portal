package com.nx.kernel.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class NxAbstractDao<PK extends Serializable, T> {
	
	private final Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public NxAbstractDao(){
		this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(PK key) {
		return (T) getSession().get(persistentClass, key);
	}
	
	public void persistEntity(T entity) {
		getSession().persist(entity);
	}
	@SuppressWarnings("unchecked")
	public void saveEntity(T entity) {
		getSession().save(entity);
	}
	
	@SuppressWarnings("unchecked")
	public void updateEntity(T entity) {
		getSession().saveOrUpdate(entity);
		getSession().flush();;
	}
	
	@SuppressWarnings("unchecked")
	public void deleteEntity(T entity) {
		getSession().delete(entity);
	}
	
	@SuppressWarnings("unchecked")
	public void mergeEntity(T entity) {
		getSession().merge(entity);
	}
	
	@SuppressWarnings("unchecked")
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}

	
}
