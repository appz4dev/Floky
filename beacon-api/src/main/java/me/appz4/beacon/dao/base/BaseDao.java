package me.appz4.beacon.dao.base;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;

public interface BaseDao<T> {
	
Long count(List<Criterion> parameters) throws Exception;
	
	T find(Long id) throws Exception;
	
	T find(List<Criterion> parameters) throws Exception;
	
	T find(Criterion... parameters) throws Exception;
	
	Long create(T o) throws Exception;
	
	void update(T o) throws Exception;
	
	void delete(T o) throws Exception;
	
	List<T> findAll(List<Criterion> parameters) throws Exception;
	
	List<T> findAll(Criterion... parameters) throws Exception;
	
	List<T> findAll(List<Criterion> parameters, List<Order> orders, Integer firstResult, Integer maxResult) throws Exception;
	
	List<T> findAll(int firstResult, int maxResult, Criterion... parameters) throws Exception;

	List<T> findAll(List<Criterion> parameters, List<Order> orders, Integer firstResult, Integer maxResult,
			List<Projection> projections) throws Exception;
	
}
