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
**  文件名: Table.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年4月23日 下午9:15:43
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.util;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class Table {
	private String schemaName;  //数据库名
	private String tableName;  //表名称
	private String tableComment; //表注释	
	private String tableType;  //表的类型，基本表或者视图
	private LocalDateTime createTime;  //表的创建时间
	private String collation;  //编码格式
	private int countOfPrimaryKey;  // 主键的数量
	private Set<Column> columns = new HashSet<>();  //该表具有的所有 列的相关信息	
	private Set<ForeginKey> foreginKeys = new HashSet<>();  //该表所具有的所有的外键信息,对应于多对一的关系
	private Set<ForeginKey> aniForeginKeys = new HashSet<>();  //对应于一对多的关系的外键信息
	
	public Table(String schemaName,String tableName,String tableComment,String tableType,String collation) {
		this.schemaName = schemaName;
		this.tableName = tableName;
		this.tableComment = tableComment;
		this.tableType = tableType;
		//this.createTime = createTime;
		this.collation = collation;
	}
	/** ========================================================================================
	 * getTableName: 
	 * @return tableName
	 * =======================================================================================*/
	public String getTableName() {
		return tableName;
	}
	/** ========================================================================================
	 * getTableComment: 
	 * @return tableComment
	 * =======================================================================================*/
	public String getTableComment() {
		return tableComment;
	}
	/** ========================================================================================
	 * getColumns: 
	 * @return columns
	 * =======================================================================================*/
	public Set<Column> getColumns() {
		return columns;
	}
	public void AddColumn(Column column) {
		this.columns.add(column);
		if (column.isPrimaryKey()) {
			this.increaseCountOfPrimaryKey();
		}
	}
	/** ========================================================================================
	 * getTableType: 
	 * @return tableType
	 * =======================================================================================*/
	public String getTableType() {
		return tableType;
	}
	/** ========================================================================================
	 * getCreateTime: 
	 * @return createTime
	 * =======================================================================================*/
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	/** ========================================================================================
	 * getCollation: 
	 * @return collation
	 * =======================================================================================*/
	public String getCollation() {
		return collation;
	}
	/** ========================================================================================
	 * getSchemaName: 
	 * @return schemaName
	 * =======================================================================================*/
	public String getSchemaName() {
		return schemaName;
	}
	/** ========================================================================================
	 * getForeginKeys: 
	 * @return foreginKeys
	 * =======================================================================================*/
	public Set<ForeginKey> getForeginKeys() {
		return foreginKeys;
	}
	/**
	 * ========================================================================================
	 * addForeginKey: 添加外键信息 
	 * @param foreginKey
	 * =======================================================================================
	 */
	public void addForeginKey(ForeginKey foreginKey) {
		this.foreginKeys.add(foreginKey);
		// 在添加外键的信息时，更新表中对应列的isForeginKey字段
		this.columns.stream().forEach(column->{
			if (column.getColumnName().equals(foreginKey.getColumnName())) {
				column.setForeginKey(true);
			}
		});
	}
	/** ========================================================================================
	 * getAniForeginKeys: 
	 * @return aniForeginKeys
	 * =======================================================================================*/
	public Set<ForeginKey> getAniForeginKeys() {
		return aniForeginKeys;
	}
	public void addAniForeginKey(ForeginKey foreginKey) {
		this.aniForeginKeys.add(foreginKey);
	}
	public int getCountOfPrimaryKey() {
		return countOfPrimaryKey;
	}
	private void increaseCountOfPrimaryKey() {
		this.countOfPrimaryKey += 1;
	}
	/**
	 * ========================================================================================
	 * isCreatedFile: 是否创建相应的文件
	 * 主键数量为1或者为视图的才创建相应的实体类、dao类以及其他的文件
	 * 对于其他情况，不予处理
	 * @return
	 * =======================================================================================
	 */
	public boolean isCreatedFile() {
		return this.countOfPrimaryKey==1 || this.tableType.equals("VIEW");
	}
}
