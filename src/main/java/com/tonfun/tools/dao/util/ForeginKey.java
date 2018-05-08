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
**  文件名: KeyColumn.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年4月26日 下午10:12:18
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.util;

/** ========================================================================================
 * @author a4423
 * 主键列
 * =======================================================================================*/
public class ForeginKey {
	private String tableName;  //表名
	private String columnName;  //列名
	private String referencedTableName;  //引用的表名
	private String referencedColumnName; //应用的列名
	public ForeginKey(String tableName,String columnName,String reTableName,String reColumnName) {
		this.tableName = tableName;
		this.columnName = columnName;
		this.referencedTableName = reTableName;
		this.referencedColumnName = reColumnName;
	}
	/** ========================================================================================
	 * getTableName: 
	 * @return tableName
	 * =======================================================================================*/
	public String getTableName() {
		return tableName;
	}
	/** ========================================================================================
	 * setTableName: 
	 * @param tableName 要设置的 tableName
	 * =======================================================================================*/
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/** ========================================================================================
	 * getColumnName: 
	 * @return columnName
	 * =======================================================================================*/
	public String getColumnName() {
		return columnName;
	}
	/** ========================================================================================
	 * setColumnName: 
	 * @param columnName 要设置的 columnName
	 * =======================================================================================*/
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/** ========================================================================================
	 * getReferencedTableName: 
	 * @return referencedTableName
	 * =======================================================================================*/
	public String getReferencedTableName() {
		return referencedTableName;
	}
	/** ========================================================================================
	 * setReferencedTableName: 
	 * @param referencedTableName 要设置的 referencedTableName
	 * =======================================================================================*/
	public void setReferencedTableName(String referencedTableName) {
		this.referencedTableName = referencedTableName;
	}
	/** ========================================================================================
	 * getReferencedColumnName: 
	 * @return referencedColumnName
	 * =======================================================================================*/
	public String getReferencedColumnName() {
		return referencedColumnName;
	}
	/** ========================================================================================
	 * setReferencedColumnName: 
	 * @param referencedColumnName 要设置的 referencedColumnName
	 * =======================================================================================*/
	public void setReferencedColumnName(String referencedColumnName) {
		this.referencedColumnName = referencedColumnName;
	}
	
	@Override
	public String toString() {
		return String.format("TableName=%s,columnName=%s,referencedTableName=%s,referencedColumnName=%s", 
							this.tableName,this.columnName,this.referencedTableName,this.referencedColumnName);
	}
}
