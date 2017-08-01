package service;

import java.util.List;

public interface BaseService<T> {
	public void save(T entity);

	public void update(T entity);

	public void delete(Long id);

	public T getById(Long id);

	public List<T> getByHQL(String hql, Object... params);
}
    
