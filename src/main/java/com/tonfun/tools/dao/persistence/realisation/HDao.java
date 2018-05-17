/*
** TONFUN CONFIDENTIAL AND PROPRIETARY.
**
** This source is the sole property of Tonfun CO.,Ltd. Reproduction or Utilization of this source
** in whole or in part is forbidden without the written consent of Tonfun CO.,Ltd.
** 此文件所有权仅归天津同丰信息技术有限公司所有。
** 未经天津同丰信息技术有限公司书面同意，严禁对此文件的全部或部分进行复制或使用。
**
** Tonfun CONFIDENTIAL.
** Copyright 2011-2018 Tonfun Corporation All Rights Reserved.
** 天津同丰信息技术有限公司机密。
** Copyright 2011-2018 天津同丰信息技术有限公司保留所有权利。
**--------------------------------------------------------------------------------------------------
**
**  文件名: HDao.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月17日 下午5:41:15
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.persistence.realisation;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tonfun.tools.dao.persistence.contract.ICRUDDao;
import com.tonfun.tools.dao.persistence.contract.IHDao;
import com.tonfun.tools.dao.persistence.contract.IQueryDao;
import com.tonfun.tools.dao.persistence.pagination.Pagination;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public abstract class HDao<T,ID extends Serializable> implements ICRUDDao<T, ID>, IQueryDao<T, ID>,IHDao<T> {
	
	private Class<T> persistentClass;

	@Autowired
	private SessionFactory sessionfactory;
	
	/** ========================================================================================
	 * 构造函数
	 * =======================================================================================*/
	@SuppressWarnings("unchecked")
	public HDao() {
		// TODO Auto-generated constructor stub
		this.persistentClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass())
								.getActualTypeArguments()[0];
	}
	
	protected Session getSession() {
		return this.sessionfactory.getCurrentSession();
	}

	/** ========================================================================================
	 * queryByPagination: 
	 * @param pagination
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.IQueryDao#queryByPagination(com.tonfun.tools.dao.persistence.pagination.Pagination)
	 * =======================================================================================*/
	@Override
	public Pagination<T> queryByPagination(Pagination<T> pagination) {
		// TODO Auto-generated method stub
		
		return null;
	}

	/** ========================================================================================
	 * paginationByCriteria: 
	 * @param pagination
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.IQueryDao#paginationByCriteria(com.tonfun.tools.dao.persistence.pagination.Pagination)
	 * =======================================================================================*/
	@Override
	public Pagination<T> paginationByCriteria(Pagination<T> pagination) {
		// TODO Auto-generated method stub
		return null;
	}

	/** ========================================================================================
	 * findById: return entity by primary id
	 * @param id
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#findById(java.io.Serializable)
	 * =======================================================================================*/
	@Override
	public T findById(final ID id) {
		// TODO Auto-generated method stub
		return (T)getSession().get(this.persistentClass, id);
	}

	/** ========================================================================================
	 * findAll: 
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#findAll()
	 * =======================================================================================*/
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/** ========================================================================================
	 * save: save entity to database 
	 * @param entity
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#save(java.lang.Object)
	 * =======================================================================================*/
	@Override
	public T save(T entity) {
		// TODO Auto-generated method stub
		getSession().save(entity);
		return entity;
	}

	/** ========================================================================================
	 * update: 
	 * @param entity
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#update(java.lang.Object)
	 * =======================================================================================*/
	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		getSession().merge(entity);
	}

	/** ========================================================================================
	 * delete: 
	 * @param entity
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#delete(java.lang.Object)
	 * =======================================================================================*/
	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub
		getSession().delete(entity);
	}

	/** ========================================================================================
	 * deleteById: 
	 * @param id
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#deleteById(java.io.Serializable)
	 * =======================================================================================*/
	@Override
	public void deleteById(final ID id) {
		// TODO Auto-generated method stub
		T t = findById(id);
		delete(t);
	}

	/** ========================================================================================
	 * saveOrUpdate: 
	 * @param t
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#saveOrUpdate(java.lang.Object)
	 * =======================================================================================*/
	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		getSession().saveOrUpdate(t);
	}

	/** ========================================================================================
	 * clear: 
	 * @see com.tonfun.tools.dao.persistence.contract.IHDao#clear()
	 * =======================================================================================*/
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		getSession().clear();
	}

	/** ========================================================================================
	 * flush: 
	 * @see com.tonfun.tools.dao.persistence.contract.IHDao#flush()
	 * =======================================================================================*/
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		getSession().flush();
	}
	

}
