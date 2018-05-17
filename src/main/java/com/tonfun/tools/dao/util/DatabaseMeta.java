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
**  文件名: DatabaseMeta.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月5日 下午4:21:55
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.util;

import java.util.Set;

/** ========================================================================================
 * @author a4423
 * 数据库的元数据信息
 * 如表的信息、外键的信息
 * =======================================================================================*/
public class DatabaseMeta {
	private Set<Table> tables;
	private Set<ForeginKey> foreginKeys;
	public DatabaseMeta(Set<Table> tables,Set<ForeginKey> foreginKeys) {
		this.tables = tables;
		this.foreginKeys = foreginKeys;
	}
	/**
	 * ========================================================================================
	 * updateTableWithForegin:将外键信息更新到对应的表中 
	 * @return
	 * =======================================================================================
	 */
	public Set<Table> updateTableWithForegin() {
		this.tables.stream().forEach(table->{
			for(ForeginKey foreginKey: this.foreginKeys) {
				if (table.getTableName().equals(foreginKey.getTableName())) {
					table.addForeginKey(foreginKey);
					
				}
				if (table.getTableName().equals(foreginKey.getReferencedTableName())) {
					table.addAniForeginKey(foreginKey);
				}
			}
		});		
		return this.tables;
	}
	/** ========================================================================================
	 * getTables: 
	 * @return tables
	 * =======================================================================================*/
	public Set<Table> getTables() {
		return tables;
	}
	/** ========================================================================================
	 * setTables: 
	 * @param tables 要设置的 tables
	 * =======================================================================================*/
	public void setTables(Set<Table> tables) {
		this.tables = tables;
	}
	/** ========================================================================================
	 * getForeginKeys: 
	 * @return foreginKeys
	 * =======================================================================================*/
	public Set<ForeginKey> getForeginKeys() {
		return foreginKeys;
	}
	/** ========================================================================================
	 * setForeginKeys: 
	 * @param foreginKeys 要设置的 foreginKeys
	 * =======================================================================================*/
	public void setForeginKeys(Set<ForeginKey> foreginKeys) {
		this.foreginKeys = foreginKeys;
	}	
}
