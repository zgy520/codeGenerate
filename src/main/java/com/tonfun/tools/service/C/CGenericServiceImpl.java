package com.tonfun.tools.service.C;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.tonfun.tools.dao.persistence.contract.IQueryDao;
import com.tonfun.tools.dao.persistence.pagination.Pagination;
import com.tonfun.tools.service.I.IGenericService;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年5月20日 下午3:16:47
*/
public class CGenericServiceImpl<T,ID extends Serializable> implements IGenericService<T, ID> {

	@Autowired
	private IQueryDao<T,ID> genericDao;
	
	@Override
	public T findById(ID id) {
		// TODO Auto-generated method stub
		return genericDao.findById(id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return genericDao.findAll();
	}

	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		return genericDao.save(entity);
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		genericDao.update(entity);
	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		genericDao.delete(entity);
	}

	@Override
	public void deleteById(ID id) {
		// TODO Auto-generated method stub
		genericDao.deleteById(id);
	}

	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(t);
	}

	@Override
	public Pagination<T> queryByPagination(Pagination<T> pagination) {
		// TODO Auto-generated method stub
		return genericDao.queryByPagination(pagination);
	}

	@Override
	public Pagination<T> paginationByCriteria(Pagination<T> pagination) {
		// TODO Auto-generated method stub
		return genericDao.paginationByCriteria(pagination);
	}

	@Override
	public Pagination<T> paginationByScrollableReslt(Pagination<T> pagination) {
		// TODO Auto-generated method stub
		return genericDao.paginationByScrollableReslt(pagination);
	}

	@Override
	public List<T> getObjListByColumnName(String columnName, String columnVal) {
		// TODO Auto-generated method stub
		return genericDao.getObjListByColumnName(columnName, columnVal);
	}

	@Override
	public List<T> getObjListByColMap(Map<String, String> colVals) {
		// TODO Auto-generated method stub
		return genericDao.getObjListByColMap(colVals);
	}

	@Override
	public List<T> getObjListByLike(String columnName, String colmnVal) {
		// TODO Auto-generated method stub
		return genericDao.getObjListByLike(columnName, colmnVal);
	}

	@Override
	public Pagination<T> getPagingObjListByQuery(Pagination<T> pagination, String whereClause) {
		// TODO Auto-generated method stub
		return genericDao.getPagingObjListByQuery(pagination, whereClause);
	}

	@Override
	public List<T> getObjListByQuery(String sqlQuery) {
		// TODO Auto-generated method stub
		return genericDao.getObjListByQuery(sqlQuery);
	}

}
