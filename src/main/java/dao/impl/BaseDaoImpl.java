package dao.impl;
import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.query.Query;


import dao.BaseDao;


public class BaseDaoImpl<T> implements BaseDao<T> {
	private Class<T> clazz;
	private Session currentSession;
	private Transaction currentTransaction;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		if(this.getClass().getGenericSuperclass() instanceof ParameterizedType) {
			Type[] type = ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments();
			//clazz = (Class<T>) type.getActualTypeArguments()[0];
			if(type != null && type.length >= 1) {
				this.clazz = (Class<T>) type[0];
			}
		}
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}
	
	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	@Override
	public void save(T t) {
		getCurrentSession().save(t);
	}

	@Override
	public void update(T t) {
		getCurrentSession().update(t);
	}

	@Override
	public void delete(Long id) {
		getCurrentSession().delete(this.findById(id));
	}

	@Override
	public T findById(Long id) {
		return (T) getCurrentSession().get(this.clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHQL(String hql, Object... params) {
		Query query = getCurrentSession().createQuery(hql);
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
		return query.getResultList();
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		/*StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
		.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());*/
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		return sessionFactory;
	}


}