package service.impl;

import java.util.List;
import javax.annotation.Resource;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;
import service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {
	private BaseDao<T> dao;

	public BaseServiceImpl() {
		dao = new BaseDaoImpl<T>();
	}

	@Override
	public void save(T entity) {
		dao.openCurrentSessionwithTransaction();
		dao.save(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	@Override
	public void update(T entity) {
		dao.openCurrentSessionwithTransaction();
		dao.update(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	@Override
	public void delete(Long id) {
		dao.openCurrentSessionwithTransaction();
		dao.delete(id);
		dao.closeCurrentSessionwithTransaction();
	}

	@Override
	public T getById(Long id) {
		dao.openCurrentSession();
		T t = dao.findById(id); 
		dao.closeCurrentSession();
		
		return t;
	}

	@Override
	public List<T> getByHQL(String hql, Object... params) {
		dao.openCurrentSession();
		List<T> t = dao.findByHQL(hql, params);
		dao.closeCurrentSession();
		
		return t;
	}
}
