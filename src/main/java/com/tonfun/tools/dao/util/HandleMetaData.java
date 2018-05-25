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
**  文件名: HandleMetaData.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年4月23日 下午9:24:19
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.util;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.tonfun.tools.File.FileGeneratorFactory;
import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.File.I.IGenericFileGenerator;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class HandleMetaData {
	
	EntityManager em;
	public HandleMetaData(EntityManager em) {
		this.em = em;
	}
	/**
	 * ========================================================================================
	 * getTableInfo: 根据数据库的名称获取表相关的信息
	 * @param schameName
	 * @throws Exception
	 * =======================================================================================
	 */
	public void getTableInfo(String schameName) throws Exception{
		Set<Table> tables = this.queryTableInfo(schameName);
		Set<ForeginKey> foreginKeys = this.queryForeginInfo(schameName);
		DatabaseMeta databaseMeta = new DatabaseMeta(tables, foreginKeys);	
		tables = databaseMeta.updateTableWithForegin();  // 更新表中的外键信息
		
		this.generateFiles(tables);
	}
	
	/**
	 * 产生根据表java相关的文件
	 * @param tables
	 */
	private void generateFiles(Set<Table> tables) {
		
		EnumSet.allOf(FileGeneratorType.class)
				.forEach(generatorType->{
					IGenericFileGenerator iGenericFileGenerator = FileGeneratorFactory.getFileGenerator(generatorType, tables);
					if (iGenericFileGenerator!=null) {
						iGenericFileGenerator.fileGenerator();
					}
				});
	}
	
	/**
	 * ========================================================================================
	 * queryForeginInfo:根据数据库名称获取该数据库中的所有外键 
	 * @param schemaName 数据库名称
	 * @return 返回该数据库中所有的外键信息
	 * =======================================================================================
	 */
	@SuppressWarnings("unchecked")
	private Set<ForeginKey> queryForeginInfo(String schemaName){
		Set<ForeginKey> foreginKeys = new HashSet<>();
		Query query = em.createNativeQuery("select table_name, column_name,referenced_table_name,referenced_column_name"
				+ " from information_schema.key_column_usage where referenced_table_name is not null "
				+ " and table_schema = '"+schemaName+"'");
		List<Object[]> list = query.getResultList();
		for(Object[] item : list) {
			ForeginKey foreginKey = new ForeginKey(item[0]==null?"":item[0].toString(), 
					item[1]==null?"":item[1].toString(), item[2]==null?"":item[2].toString(), 
							item[3]==null?"":item[3].toString());
			foreginKeys.add(foreginKey);
		}
		return foreginKeys;
	}
	
	/**
	 * ========================================================================================
	 * queryTableInfo:获取该数据库下的所有表信息 
	 * select * from INFORMATION_SCHEMA.TABLES 获取到的信息包括如下信息：
	 * TABLE_CATALOG,TABLE_SCHEMA,TABLE_NAME,TABLE_TYPE,ENGINE,VERSION,ROW_FORMAT,TABLE_ROWS,
	 * AVG_ROW__LENGTH,DATA_LENGTH,MAX_DATA_LENGTH,INDEX_LENGTH,DATA_FREE,AUTO_INCREMENT,CREATE_TIME,
	 * UPDATE_TIME,CHECK_TIME,TABLE_COLLATION,CHECKSUM,CREATE_OPTIONS,TABLE_COMMENT
	 * @return
	 * =======================================================================================
	 */
	@SuppressWarnings("unchecked")
	private Set<Table> queryTableInfo(String schemaName) {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
		Set<Table> schameTables = new HashSet<Table>();
		Query query = em.createNativeQuery("select * from INFORMATION_SCHEMA.TABLES where TABLE_SCHEMA = '"+schemaName+"'");
		List<Object[]> list = query.getResultList();
		for(Object[] item : list) {
			Table table = new Table(schemaName,item[2]==null?"":item[2].toString(), 
					item[20]==null?"":item[20].toString(), item[3]==null?"":item[3].toString(), item[17]==null?"":item[17].toString());
			schameTables.add(table);
		}
		schameTables = queryColumnByTable(schameTables);
		return schameTables;
	}
	/**
	 * ========================================================================================
	 * queryColumnByTable: 根据表获取相应表中的列信息
	 * @param tables
	 * @return
	 * =======================================================================================
	 */
	@SuppressWarnings("unchecked")
	private Set<Table> queryColumnByTable(Set<Table> tables){		
		for (Table table : tables) {
			Query query = em.createNativeQuery("select COLUMN_NAME,IS_NULLABLE,COLUMN_TYPE,COLUMN_KEY,EXTRA,COLUMN_COMMENT,ORDINAL_POSITION from"
					+ "	information_schema.columns where table_schema = '"+table.getSchemaName()+"'  and table_name = '"+table.getTableName()+"'");
			List<Object[]> list = query.getResultList();
			for(Object[] item : list) {				
				String columnName = item[0].toString();
				String columnType = item[2].toString();
				boolean isNull = item[1].toString().equals("YES")?true:false;
				boolean isPrimaryKey = item[3]==null?false:item[3].equals("PRI")?true:false;
				String columnComment = item[5].toString();
				int serial = Integer.parseInt(item[6].toString());
				Column column = new Column(columnName, columnType, isNull, isPrimaryKey, columnComment,serial);
				table.AddColumn(column);
			}
		}		
		return tables;
	}
}
