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
**  文件名: DataBaseRepository.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年4月23日 下午9:05:15
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.stereotype.Repository;

import com.tonfun.tools.dao.util.HandleMetaData;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
@Repository
public class DataBaseRepository {
	@PersistenceContext
	private EntityManager em;	
	
	public void getMeta() throws Exception {
		System.out.println("执行了");
		
		HandleMetaData handleMetaData = new HandleMetaData(em);
		SessionImplementor sessionImpl = (SessionImplementor)em.getDelegate();
		DatabaseMetaData metaData = null;
		try {
			metaData = sessionImpl.connection().getMetaData();			
			ResultSet resultSet = metaData.getTables(null, null, "%", null);
			while(resultSet.next()) {
				handleMetaData.getTableInfo(resultSet.getString(1));
				System.out.println("执行完毕");
				break;
			}			
			resultSet.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
