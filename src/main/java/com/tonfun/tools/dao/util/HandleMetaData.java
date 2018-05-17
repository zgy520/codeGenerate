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

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.constraints.Null;

import com.tonfun.tools.File.C.GenerateDaoJavaFile;
import com.tonfun.tools.File.C.GenerateModelJavaFile;
import com.tonfun.tools.File.I.FileGeneratorInterface;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.OutputStyle;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class HandleMetaData {
	
	EntityManager em;
	public HandleMetaData(EntityManager em) {
		this.em = em;
	}
	
	public void getTableInfo(String schameName) throws Exception{
		Set<Table> tables = this.queryTableInfo(schameName);
		Set<ForeginKey> foreginKeys = this.queryForeginInfo(schameName);
		DatabaseMeta databaseMeta = new DatabaseMeta(tables, foreginKeys);		
		
		FileOperator fileOperator = new FileOperator(OutputStyle.Default);		
		fileOperator.setPackageName(Optional.of("com.tonfun.tools.model"));		
		
		generateModel(databaseMeta.updateTableWithForegin(), fileOperator);
		/*for (Table table : tables) {
			generateModel(table,fileOperator);
		}	*/
		// 产生Dao文件
		FileOperator daoFileOperator = new FileOperator(OutputStyle.Default);
		daoFileOperator.setPackageName(Optional.of("com.tonfun.tools.dao.test"));		
		generateDaoClass(databaseMeta.getTables(), daoFileOperator);
	}
	
	private void generateDaoClass(Set<Table> tables,FileOperator fileOperator) {
		FileGeneratorInterface fileGeneratorInterface = new GenerateDaoJavaFile(tables);
		for(Table table : tables) {
			if (table.isCreatedFile()) {
				fileGeneratorInterface.generateCodeFile(table, fileOperator);
			}			
		}
	}
	
	/**
	 * ========================================================================================
	 * generateModel: 产生实体类 
	 * @param tables
	 * @param outputDir
	 * @throws IOException
	 * =======================================================================================
	 */
	private void generateModel(Set<Table> tables,FileOperator outputDir) throws IOException {
				
		FileGeneratorInterface fileGenerator = new GenerateModelJavaFile(tables);
		for(Table table : tables) {
			if (table.isCreatedFile()) {
				fileGenerator.generateCodeFile(table,outputDir);
			}		
		}
		//fileGenerator.generateCodeFile(table, outputDir);			
	}
	
	/**
	 * ========================================================================================
	 * queryForeginInfo:根据数据库名称获取该数据库中的所有外键 
	 * @param schemaName 数据库名称
	 * @return 返回该数据库中所有的外键信息
	 * =======================================================================================
	 */
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
	 * @return
	 * =======================================================================================
	 */
	private Set<Table> queryTableInfo(String schemaName) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
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
