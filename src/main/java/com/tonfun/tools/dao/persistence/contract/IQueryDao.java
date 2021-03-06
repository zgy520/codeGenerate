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
**  文件名: IQueryDao.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月8日 下午10:05:25
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.persistence.contract;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tonfun.tools.dao.persistence.pagination.Pagination;

/** ========================================================================================
 * @author a4423
 * 常见的查询的底层实现类
 * =======================================================================================*/
public interface IQueryDao<T,ID extends Serializable> extends ICRUDDao<T, ID> {
	Pagination<T> queryByPagination(Pagination<T> pagination);  // 根据分页进行查询
	Pagination<T> paginationByCriteria(Pagination<T> pagination);  // 根据Criteria API 进行分页查询	
	Pagination<T> paginationByScrollableReslt(Pagination<T> pagination); // 根据ScrollableResults API进行分页查询
	List<T> getObjListByColumnName(String columnName,String columnVal);  //根据列名和列值获取实体的集合
	List<T> getObjListByColMap(Map<String, String> colVals);  //根据列和值的集合获取实体的集合
	List<T> getObjListByLike(String columnName,String colmnVal);  //like查询
	Pagination<T> getPagingObjListByQuery(Pagination<T> pagination,String whereClause);  //根据sql语句查询对象列表
	List<T> getObjListByQuery(String sqlQuery); // 根据查询条件查询对象列表
}
