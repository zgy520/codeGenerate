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
**  文件名: Column.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年4月23日 下午9:16:43
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.util;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class Column {
	private String columnName;  //列名
	private String columnType;  //类型
	private int size;  //列大小
	private boolean isNull;  //是否可为空
	private boolean isPrimaryKey;  //是否为主键
	private String columnComment;  //列注释
	private Integer serial;  //序列
	public Column(String columnName,String columnType,boolean isNull,boolean isPrimaryKey,String columnComment,Integer serial) {
		this.columnName = columnName;
		this.columnType = columnType;		
		this.isNull = isNull;
		this.isPrimaryKey = isPrimaryKey;
		this.columnComment = columnComment;		
		this.serial = serial;
	}
	/** ========================================================================================
	 * getColumnName: 
	 * @return columnName
	 * =======================================================================================*/
	public String getColumnName() {
		return columnName;
	}
	/** ========================================================================================
	 * getColumnType: 
	 * @return columnType
	 * =======================================================================================*/
	public String getColumnType() {
		return columnType;
	}
	/** ========================================================================================
	 * getSize: 
	 * @return size
	 * =======================================================================================*/
	public int getSize() {
		return size;
	}
	/** ========================================================================================
	 * isNull: 
	 * @return isNull
	 * =======================================================================================*/
	public boolean isNull() {
		return isNull;
	}
	/** ========================================================================================
	 * isPrimaryKey: 
	 * @return isPrimaryKey
	 * =======================================================================================*/
	public boolean isPrimaryKey() {
		return isPrimaryKey;
	}
	/** ========================================================================================
	 * getColumnComment: 
	 * @return columnComment
	 * =======================================================================================*/
	public String getColumnComment() {
		return columnComment;
	}
	/** ========================================================================================
	 * getSerial: 
	 * @return serial
	 * =======================================================================================*/
	public Integer getSerial() {
		return serial;
	}		
}
