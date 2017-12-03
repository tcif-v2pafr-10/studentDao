package nl.hu.pafr.dao.jpa;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;

import nl.hu.pafr.dao.GenericDao;

public abstract class AbstractDaoJpaImpl<T> implements GenericDao<T> {
	protected EntityManager em;
	protected Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDaoJpaImpl(EntityManager entityManager) {
		this.em = entityManager;
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<T>) pt.getActualTypeArguments()[0];
	}

	@Override
	public void insert(T entity) {
		em.persist(entity);
	}

	@Override
	public void update(T entity) {
		em.persist(entity);
	}

	@Override
	public T findById(int id) {
		T entity = (T) em.find(type, id);
		return entity;
	}

	@Override
	public void delete(T entity) {
		em.remove(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		List<T> entities = (List<T>) em.createQuery("from "+type.getName()).getResultList();
		return entities;
	}
}
