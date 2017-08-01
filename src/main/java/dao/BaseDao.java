package dao;

import java.util.List;

import org.hibernate.Session;

public interface BaseDao<T> {
	public Session openCurrentSession();
	
	public Session openCurrentSessionwithTransaction();
	
	public void closeCurrentSession();
	
	public void closeCurrentSessionwithTransaction();
	
	public void save(T t);

	public void update(T t);

	public void delete(Long id);

	public T findById(Long id);

	public List<T> findByHQL(String hql, Object... params);
}