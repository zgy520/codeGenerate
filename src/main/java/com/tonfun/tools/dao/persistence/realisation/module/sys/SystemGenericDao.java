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
**  文件名: SystemGenericDao.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月8日 下午9:30:53
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.persistence.realisation.module.sys;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.tonfun.tools.dao.persistence.realisation.CCQueryDao;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class SystemGenericDao<T,ID extends Serializable> extends CCQueryDao<T, ID> implements ISystemGenericDao<T, ID> {

	@PersistenceContext(name="entityManagerFactory",unitName="system")
	@Resource(name="entityManagerFactory")
	protected EntityManager sysManager;
	/** ========================================================================================
	 * getEntityManager: 
	 * @return
	 * @see com.tonfun.tools.dao.persistence.realisation.CCRUDDao#getEntityManager()
	 * =======================================================================================*/
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return this.sysManager;
	}
}
