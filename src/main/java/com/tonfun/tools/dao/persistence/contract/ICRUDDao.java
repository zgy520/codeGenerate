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
**  文件名: IGenericDao.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月8日 下午8:49:48
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.persistence.contract;

import java.io.Serializable;
import java.util.List;

/** ========================================================================================
 * @author a4423
 * 泛型dao的接口，包含基本的增加、删除、修改和查询操作
 * =======================================================================================*/
public interface ICRUDDao<T,ID extends Serializable> {
	T findById(ID id);  // 根据id获取对象
	List<T> findAll();  //返回所有的实体信息
	T save(T entity);  // 保存对象
	void update(T entity);  // 更新对象
	void delete(T entity);  // 删除对象
	void deleteById(ID id); // 根据id删除对象
}
