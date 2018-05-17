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
**  文件名: CCQueryDao.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月17日 下午7:40:05
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.persistence.realisation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;

import com.tonfun.tools.dao.persistence.contract.IQueryDao;
import com.tonfun.tools.dao.persistence.pagination.Pagination;
import com.tonfun.tools.dao.persistence.pagination.SortOrder;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public abstract class CCQueryDao<T,ID extends Serializable> extends CCRUDDao<T, ID> implements IQueryDao<T, ID> {
	/**
	 * ========================================================================================
	 * queryByPagination: 根据分页获取所有的数据
	 * @param pagination
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.IQueryDao#queryByPagination(com.tonfun.tools.dao.persistence.pagination.Pagination)
	 * =======================================================================================
	 */
	@SuppressWarnings("unchecked")
	public Pagination<T> queryByPagination(Pagination<T> pagination){
		Query query = null;
		if (pagination.getOrderField()!=null && pagination.getOrderBy()!=null) {
			query = getEntityManager().createQuery(" from "+this.clazz.getName()+" order by "+
											 pagination.getOrderField()+" "+pagination.getOrderBy());
		}else {
			query = getEntityManager().createQuery(" from "+this.clazz.getName());
		}			
		query.setFirstResult((pagination.getPager() - 1) * pagination.getCount());
		query.setMaxResults(pagination.getCount());		
		List<T> tList = query.getResultList();
		pagination.setListData(tList);
		long totalRecords = getRecordsOfEntity();
		pagination.setTotalRecords(totalRecords);			
		return pagination;
	}
	/**
	 * ========================================================================================
	 * getRecordsOfEntity: 获取实体的总数量
	 * @return
	 * =======================================================================================
	 */
	private long getRecordsOfEntity() {
		Query query = getEntityManager().createQuery("select count(*) from "+this.clazz.getName());
		long count =(Long)query.getSingleResult();
		return count;
	}
	/**
	 * ========================================================================================
	 * paginationByCriteria:根据API 进行查询 
	 * @param pagination
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.IQueryDao#paginationByCriteria(com.tonfun.tools.dao.persistence.pagination.Pagination)
	 * =======================================================================================
	 */
	public Pagination<T> paginationByCriteria(Pagination<T> pagination){
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(this.clazz);
		Root<T> from = criteriaQuery.from(this.clazz);
		if (pagination.getOrderBy() == SortOrder.ASC) {
			criteriaQuery.orderBy(criteriaBuilder.asc(from.get(pagination.getOrderField())));
		}else if (pagination.getOrderBy() == SortOrder.DESC) {
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get(pagination.getOrderField())));
		}
		CriteriaQuery<T> select = criteriaQuery.select(from);
		TypedQuery<T> typedQuery = getEntityManager().createQuery(select);
		typedQuery.setFirstResult((pagination.getPager() - 1) * pagination.getCount());
		typedQuery.setMaxResults(pagination.getCount());
		pagination.setListData(typedQuery.getResultList());
		pagination.setTotalRecords(getTotalRecordsByCriteria());
		return pagination;
	}
	/**
	 * ========================================================================================
	 * getTotalRecordsByCriteria: 根据criteria api 获取总的数量
	 * @return
	 * =======================================================================================
	 */
	private long getTotalRecordsByCriteria() {
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
		countQuery.select(criteriaBuilder.count(countQuery.from(this.clazz)));
		long count = getEntityManager().createQuery(countQuery).getSingleResult();
		return count;
	}
	
	/** ========================================================================================
	 * paginationByScrollableReslt:  根据ScrollableResults进行分页，只需要一次数据库调用，更高效
	 * @param pagination
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.IQueryDao#paginationByScrollableReslt(com.tonfun.tools.dao.persistence.pagination.Pagination)
	 * =======================================================================================*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Pagination<T> paginationByScrollableReslt(Pagination<T> pagination) {
		// TODO Auto-generated method stub
		Session session = getEntityManager().unwrap(Session.class);
		org.hibernate.query.Query query = null;
		if (pagination.getOrderField()!=null && pagination.getOrderBy()!=null) {
			query = session.createQuery(" from "+this.clazz.getName()+" order by "+
											 pagination.getOrderField()+" "+pagination.getOrderBy());
		}else {
			query = session.createQuery(" from "+this.clazz.getName());
		}
		
		ScrollableResults scrollableResults = query.setReadOnly(true)
												.setCacheable(false)
												.setFetchSize(Integer.MIN_VALUE).scroll(ScrollMode.FORWARD_ONLY);
		scrollableResults.first();
		scrollableResults.scroll((pagination.getPager() - 1) * pagination.getCount());
		
		List<T> listData = new ArrayList<>();
		int i = 0;
		while(pagination.getCount() > i++) {
			listData.add((T)scrollableResults.get(0));
			if (!scrollableResults.next()) {
				break;
			}
		}
		pagination.setListData(listData);
		
		// 获取记录的总数量
		scrollableResults.last();
		pagination.setTotalRecords(scrollableResults.getRowNumber() + 1);
		scrollableResults.close();		
		return pagination;
	}
	/** ========================================================================================
	 * getObjListByColumnName: 
	 * @param columnName
	 * @param columnVal
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.IQueryDao#getObjListByColumnName(java.lang.String, java.lang.String)
	 * =======================================================================================*/
	@Override
	public List<T> getObjListByColumnName(String columnName, String columnVal) {
		// TODO Auto-generated method stub
		try {
			CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<T> criteria = builder.createQuery(this.clazz);
			Root<T> from = criteria.from(this.clazz);
			criteria.select(from);
			criteria.where(builder.equal(from.get(columnName),columnVal));
			
			TypedQuery<T> typed = getEntityManager().createQuery(criteria);
			return typed.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	/** ========================================================================================
	 * getObjListByColMap: 
	 * @param colVals
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.IQueryDao#getObjListByColMap(java.util.Map)
	 * =======================================================================================*/
	@Override
	public List<T> getObjListByColMap(Map<String, String> colVals) {
		// TODO Auto-generated method stub
		int size = colVals.size();
		if (size==0) {
			return null;
		}
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(clazz);
		Root<T> from = criteria.from(clazz);
		criteria.select(from);
		
		List<Predicate> mutiColPredicate = new ArrayList<>();
		
		for(String key : colVals.keySet()) {					
			mutiColPredicate.add(builder.and(builder.equal(from.get(key),colVals.get(key))));
		}		
		
		criteria.where(builder.and(mutiColPredicate.toArray(new Predicate[mutiColPredicate.size()])));
		TypedQuery<T> typed = getEntityManager().createQuery(criteria);
		return typed.getResultList();
	}
	/** ========================================================================================
	 * getObjListByLike: 
	 * @param columnName
	 * @param colmnVal
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.IQueryDao#getObjListByLike(java.lang.String, java.lang.String)
	 * =======================================================================================*/
	@Override
	public List<T> getObjListByLike(String columnName, String colmnVal) {
		// TODO Auto-generated method stub
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> criteria = builder.createQuery(this.clazz);
		Root<T> from = criteria.from(this.clazz);
		criteria.select(from);
	
		criteria.where(builder.like(from.get(columnName),"%"+colmnVal+"%"));
		TypedQuery<T> typed = getEntityManager().createQuery(criteria);
		try {
			return typed.getResultList();
		}catch (Exception e) {
			// TODO: handle exception
			return null;
		}	
	}
	/** ========================================================================================
	 * getPagingObjListByQuery: 
	 * @param pagination
	 * @param whereClause
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.IQueryDao#getPagingObjListByQuery(com.tonfun.tools.dao.persistence.pagination.Pagination, java.lang.String)
	 * =======================================================================================*/
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<T> getPagingObjListByQuery(Pagination<T> pagination, String whereClause) {
		// TODO Auto-generated method stub
		if (pagination.getOrderBy()==null && whereClause.trim().contains("orderby")) {
			whereClause = whereClause.split("order")[0];
		}
		
		Query query = getEntityManager().createQuery("Select t from "+ this.clazz.getName() +" t " + whereClause);
		
		pagination.setTotalRecords(Long.valueOf(query.getResultList().size()));
		
		query.setFirstResult((pagination.getPager() - 1) * pagination.getCount());
		query.setMaxResults(pagination.getCount());	
		List<T> result = query.getResultList();
		
		
		pagination.setListData(Collections.unmodifiableList(result));
		
		return pagination;
	}
	/** ========================================================================================
	 * getObjListByQuery: 
	 * @param sqlQuery
	 * @return
	 * @see com.tonfun.tools.dao.persistence.contract.IQueryDao#getObjListByQuery(java.lang.String)
	 * =======================================================================================*/
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getObjListByQuery(String sqlQuery) {
		// TODO Auto-generated method stub
		try {
			Query query = getEntityManager().createQuery("Select t from "+ this.clazz.getName() +" t " + sqlQuery);
			List<T> list = query.getResultList();
			
			return Collections.unmodifiableList(list);
		}catch(Exception exception) {
			System.out.println(exception.getMessage());
		}
		return null;
	}
}
