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
**  文件名: CGenericDao.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月8日 下午9:05:23
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.persistence.realisation;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import com.tonfun.tools.dao.persistence.contract.ICRUDDao;

/** ========================================================================================
 * @author a4423
 * 增删改查对应的底层类
 * =======================================================================================*/
@Transactional
public abstract class CCRUDDao<T,ID extends Serializable> implements ICRUDDao<T, ID> {
	protected Class<T> clazz;  // 当前操作的实体类	
	
	@SuppressWarnings("unchecked")
	public CCRUDDao(){
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	
	
	public abstract EntityManager getEntityManager();
	
	/**
	 * ========================================================================================
	 * findById: 根据实体ID返回对应的实体对象
	 * @param id
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#findById(java.io.Serializable)
	 * =======================================================================================
	 */
	//@Transactional("transactionManager")
	public T findById(ID id) {
		return getEntityManager().find(this.clazz, id);
	}
	/**
	 * ========================================================================================
	 * findAll: 返回当前实体的所有对象
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#findAll()
	 * =======================================================================================
	 */
	//@Transactional("transactionManager")
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		return getEntityManager().createQuery("from "+this.clazz.getName()).getResultList();
	}
	/**
	 * ========================================================================================
	 * save: 保存实体对象
	 * @param entity
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#save(java.lang.Object)
	 * =======================================================================================
	 */
	@Transactional("transactionManager")
	public T save(T entity) {
		getEntityManager().persist(entity);
		return entity;
	}
	/**
	 * ========================================================================================
	 * update: 更新实体对象
	 * @param entity
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#update(java.lang.Object)
	 * =======================================================================================
	 */
	@Transactional("transactionManager")
	public void update(T entity) {
		getEntityManager().merge(entity);
	}
	/**
	 * ========================================================================================
	 * delete: 根据实体删除对象
	 * @param entity
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#delete(java.lang.Object)
	 * =======================================================================================
	 */
	@Transactional("transactionManager")
	public void delete(T entity) {
		if (entity!=null) {
			getEntityManager().remove(entity);
		}else {
			throw new NullPointerException("需要删除的实体不能为空");
		}
		
	}
	/**
	 * ========================================================================================
	 * deleteById: 根据ID删除实体对象
	 * @param id
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#deleteById(java.io.Serializable)
	 * =======================================================================================
	 */
	@Transactional("transactionManager")
	public void deleteById(ID id) {
		T entity = this.findById(id);
		this.delete(entity);
	}	


	/** ========================================================================================
	 * saveOrUpdate: 
	 * @param t
	 * @see com.tonfun.tools.dao.persistence.contract.ICRUDDao#saveOrUpdate(java.lang.Object)
	 * =======================================================================================*/
	//@Transactional("transactionManager")
	@Override
	public void saveOrUpdate(T t) {
		// TODO Auto-generated method stub
		
	}
	
}
