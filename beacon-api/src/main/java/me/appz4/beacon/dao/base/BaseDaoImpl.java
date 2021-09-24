package me.appz4.beacon.dao.base;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	private Class<T> type;
	
	public BaseDaoImpl(Class<T> t) {
		this.type = t;
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional(value="services", propagation = Propagation.MANDATORY)
	@SuppressWarnings("unchecked")
	public T find(Long id) throws Exception {
		return (T)getCurrentSession().get(type, id);
	}
	
	@Transactional(value="services", propagation = Propagation.MANDATORY)
	@SuppressWarnings("unchecked")
	public T find(List<Criterion> parameters) throws Exception {
		Criteria c = getCurrentSession().createCriteria(type);
		for(Criterion i : parameters) {
			c.add(i);
		}
		List<T> list = (List<T>)c.list();
		if(list.size() > 0) return list.get(0);
		return null;
	}
	
	@Transactional(value="services", propagation = Propagation.MANDATORY)
	@SuppressWarnings("unchecked")
	public T find(Criterion... parameters) throws Exception {
		Criteria c = getCurrentSession().createCriteria(type);
		for(Criterion i : parameters) {
			c.add(i);
		}
		List<T> list = (List<T>)c.list();
		if(list.size() > 0) return list.get(0);
		return null;
	}
	
	@Transactional(value="services", propagation = Propagation.MANDATORY)
	public Long create(T o) throws Exception {
		return (Long)getCurrentSession().save(o);
	}
	
	@Transactional(value="services", propagation = Propagation.MANDATORY)
	public void update(T o) throws Exception {
		getCurrentSession().update(o);
	}
	
	@Transactional(value="services", propagation = Propagation.MANDATORY)
	public void delete(T o) throws Exception {
		getCurrentSession().delete(o);
	}
	
	@Transactional(value="services", propagation = Propagation.MANDATORY)
	public Long count(List<Criterion> parameters) throws Exception {
		Criteria c = getCurrentSession().createCriteria(type);
		if(parameters != null) {
			for(Criterion i : parameters) {
				c.add(i);
			}
		}
		c.setProjection(Projections.rowCount()).uniqueResult();
		return (Long)c.list().get(0);
	}

	@Override
	public List<T> findAll(List<Criterion> parameters) throws Exception {
		return findAll(parameters.toArray(new Criterion[]{}));
	}

	@Override
	public List<T> findAll(Criterion... parameters) throws Exception {
		Criteria c = getCurrentSession().createCriteria(type);
		if(parameters != null) {
			for(Criterion i : parameters) {
				c.add(i);
			}
		}
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>)c.list();
		return list;
	}
	
	@Override
	public List<T> findAll(int firstResult, int maxResult, Criterion... parameters) throws Exception {
		Criteria c = getCurrentSession().createCriteria(type);
		if(parameters != null) {
			for(Criterion i : parameters) {
				c.add(i);
			}
		}
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>)c.list();
		return list;
	}

	@Override
	public List<T> findAll(List<Criterion> parameters, List<Order> orders, Integer firstResult, Integer maxResult) throws Exception {
		return findAllBy(parameters, orders, firstResult, maxResult);
	}
	
	@Override
	public List<T> findAll(List<Criterion> parameters, List<Order> orders, Integer firstResult, Integer maxResult, List<Projection> projections) throws Exception {
		return findAllBy(parameters, orders, firstResult, maxResult, projections);
	}
	
	private List<T> findAllBy(List<Criterion> parameters, List<Order> orders, Integer firstResult, Integer maxResult) throws Exception {
		return findAllBy(parameters, orders, firstResult, maxResult, new ArrayList<Projection>());
	}

	private List<T> findAllBy(List<Criterion> parameters, List<Order> orders, Integer firstResult, Integer maxResult, List<Projection> projections) throws Exception {
		Criteria c = getCurrentSession().createCriteria(type);
		if(parameters != null) {
			for(Criterion i : parameters) {
				c.add(i);
			}
		}
		if(orders != null) {
			for(Order i : orders) {
				c.addOrder(i);
			}
		}
		if(firstResult != null) c.setFirstResult(firstResult);
		if(maxResult != null) c.setMaxResults(maxResult);
		if(!projections.isEmpty()) {
			ProjectionList prList = Projections.projectionList();
			for(Projection i : projections) {
				prList.add(i);
			}
			c.setProjection(prList);
		}
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>)c.list();
		return list;
	}
	
}
