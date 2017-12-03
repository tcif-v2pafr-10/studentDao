package nl.hu.pafr.dao;

import java.util.List;

public interface GenericDao<T> {
	T findById(int id);
	void update(T entity);
	void delete(T entity);
	List<T> getAll();
	void insert(T entity);
}
