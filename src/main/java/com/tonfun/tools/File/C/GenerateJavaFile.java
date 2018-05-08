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
**  文件名: GenerateJavaFile.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年4月26日 下午9:06:55
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.File.C;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.mapping.model.CamelCaseSplittingFieldNamingStrategy;

import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.File.I.FileGeneratorInterface;
import com.tonfun.tools.dao.util.Column;
import com.tonfun.tools.dao.util.ForeginKey;
import com.tonfun.tools.dao.util.Table;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.Utils;
import com.tonfun.tools.indepent.TypeConvetor.TypeConvert;
import com.tonfun.tools.indepent.TypeConvetor.TypeConvertBetweenMySQLAndJava;

import javassist.NotFoundException;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class GenerateJavaFile implements FileGeneratorInterface {
	final TypeConvert typeConvert;
	private Set<Table> tables;
	/** ========================================================================================
	 * 构造函数
	 * =======================================================================================*/
	public GenerateJavaFile(Set<Table> tables) {
		// TODO Auto-generated constructor stub
		typeConvert = new TypeConvertBetweenMySQLAndJava();
		this.tables = tables;
	}

	/** ========================================================================================
	 * generateCodeFile: 
	 * @param table
	 * @param fileOperator
	 * @return
	 * @see com.tonfun.tools.File.I.FileGeneratorInterface#generateCodeFile(com.tonfun.tools.dao.util.Table, com.tonfun.tools.helper.FileOperator)
	 * =======================================================================================*/
	@Override
	public ErrorCode generateCodeFile(Table table, FileOperator fileOperator) {
		// TODO Auto-generated method stub
		ErrorCode errorCode = new DefaultErrorCode();
		File file = new File(fileOperator.getPackageDir(),com.tonfun.tools.helper.Utils.captureName(table.getTableName())+".java");
		
		try {
			if (!file.exists()) {
				file.createNewFile();				
			}
			
			FileWriter fileWriter = new FileWriter(file);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("package "+fileOperator.getPackage_Name()+";");  // 产生包名
			
			outputPackage(printWriter);  //将相关的包输出
			
			// 以下两行用于在类的头部添加实体类的标识
			printWriter.println("@Entity");
			printWriter.println("@Table(name=\""+table.getTableName()+"\")");
			printWriter.println("//对应的表为:"+table.getTableName());
			printWriter.println("public class "+Utils.captureName(table.getTableName()) +"{");  //产生类名
			//产生类中的内容
			createClassContent(table, printWriter);
			printWriter.println("}");  // 产生结尾符号
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorCode.setErrCode(ErrCode.FAIL);
			errorCode.setErrMsg("写入文件失败:"+e.getMessage());
		}
		
		return errorCode;
	}
	/**
	 * ========================================================================================
	 * outputPackage: 输出包名
	 * @param printWriter
	 * =======================================================================================
	 */
	private void outputPackage(PrintWriter printWriter) {
		printWriter.println("\r\n\r\nimport javax.persistence.GeneratedValue;\r\n" + 
				"import javax.persistence.GenerationType;\r\n" + 
				"import javax.persistence.Id;\r\n" + 
				"import java.time.LocalTime;\r\n"+
				"import java.time.LocalDateTime;\r\n"+
				"import java.time.LocalDate;\r\n"+
				"import javax.persistence.Table;\r\n"+
				"import javax.persistence.Entity;\r\n"+
				"import javax.validation.constraints.*;\r\n"+
				"import javax.persistence.ManyToOne;\r\n"+
				"import javax.persistence.FetchType;\r\n"+
				"import javax.persistence.JoinColumn;\r\n"+
				"import java.util.Set;\r\n"+
				"import java.util.HashSet;\r\n"+
				"import javax.persistence.OneToMany;\r\n");
		printWriter.println("\r\n\r\n\r\n");
	}
	
	/**
	 * ========================================================================================
	 * createClassContent:创建类中的内容 
	 * @param table
	 * =======================================================================================
	 */
	private void createClassContent(Table table,PrintWriter printWriter) {
		Set<Column> columns = table.getColumns();
		columns.stream().sorted(Comparator.comparing(Column::getSerial))
				.forEach(column->{
					if (column.isPrimaryKey()) {
						printWriter.println("  @Id");
						printWriter.println("  @GeneratedValue(strategy=GenerationType.IDENTITY)");
						printWriter.println("  private Long "+column.getColumnName()+";");
					}else {
						printWriter.println("  //"+column.getColumnType() + " " + column.getColumnComment());
						if (!column.isNull()) {  //判断是否可为空，如果为空，则不做处理，否则增加@notNull注解
							printWriter.println("  @NotNull");
						}
						checkTypeAndOutput(column, printWriter);						
					}
				});		
		generateForeginContents(table, printWriter);
		generateFieldMethods(columns, printWriter);
		// 产生关系实体的get和set方法
		generateGetAndSetForRelationField(table, printWriter);
	}
	/**
	 * ========================================================================================
	 * createForeginCotent: 产生外键的内容即关系内容
	 * @param foreginKeys 
	 * @param printWriter
	 * =======================================================================================
	 */
	private void generateForeginContents(Table table,PrintWriter printWriter) {
		printWriter.println("  //以下是对应的实体关系");
		Set<ForeginKey> foreginKeys = table.getForeginKeys();
		/**
		 * 添加多对一的关系
		 */
		foreginKeys.stream().forEach(foreginKey->{
			if (this.countOfPrimaryKeys(foreginKey.getReferencedTableName()) && !foreginKey.getTableName().equals(foreginKey.getReferencedTableName())) {
				printWriter.println("  @ManyToOne(fetch = FetchType.LAZY)");
				printWriter.println("  @JoinColumn(name = \""+foreginKey.getColumnName()+"\")");
				printWriter.println("  private "+Utils.captureName(foreginKey.getReferencedTableName())+
						"  "+foreginKey.getReferencedTableName().toLowerCase()+";\r\n");
			}		
		});
		/**
		 * 添加一对多的关系
		 */
		table.getAniForeginKeys().stream().forEach(aniForeginKey->{
			if (this.countOfPrimaryKeys(aniForeginKey.getTableName())) {
				printWriter.println("  @OneToMany(mappedBy = \""+aniForeginKey.getReferencedTableName().toLowerCase()+"\")");				
				printWriter.println("  private Set<"+Utils.captureName(aniForeginKey.getTableName())+
						">  "+aniForeginKey.getTableName().toLowerCase()+"s = new HashSet<>();\r\n");
			}
		});
		printWriter.println("  //关系实体创建完毕");
	}
	/**
	 * 根据实体之间的关系产生关系字段的get和set方法
	 * @param table
	 * @param printWriter
	 */
	private void generateGetAndSetForRelationField(Table table,PrintWriter printWriter) {
		table.getForeginKeys().stream().forEach(foreginKey->{
			String className = Utils.captureName(foreginKey.getReferencedTableName());
			if (!foreginKey.getTableName().equals(foreginKey.getReferencedTableName())) {  // 如果表明和应用的表明一样，则不做处理
				/**
				 * 填充get方法
				 */
				printWriter.println("  public "+className+" get"+className+"() {");
				printWriter.println("    return this."+className.toLowerCase()+";");
				printWriter.println("  }\r\n");
				/**
				 * 填充set方法
				 */
				printWriter.println("  public void set"+className+"("+className +" "+className.toLowerCase()+") {");
				printWriter.println("    this."+className.toLowerCase()+" = "+className.toLowerCase()+";");
				printWriter.println("  }\r\n");
			}
			
		});
		table.getAniForeginKeys().stream().forEach(aniForeginKey -> {
			String className = Utils.captureName(aniForeginKey.getTableName());
			if (this.countOfPrimaryKeys(aniForeginKey.getTableName())) {
				/**
				 * 填充get方法
				 */
				printWriter.println("  public Set<"+className+"> get"+className+"() {");
				printWriter.println("    return this."+className.toLowerCase()+"s;");
				printWriter.println("  }\r\n");
				/**
				 * 填充set方法
				 */
				printWriter.println("  public void set"+className+"(Set<"+className +"> "+className.toLowerCase()+"s) {");
				printWriter.println("    this."+className.toLowerCase()+"s = "+className.toLowerCase()+"s;");
				printWriter.println("  }\r\n");
			}			
		});
	}
	
	/**
	 * ========================================================================================
	 * checkTypeAndOutput: 检查类型并产生相应的字段信息
	 * @param column
	 * @param printWriter
	 * =======================================================================================
	 */
	private void checkTypeAndOutput(Column column,PrintWriter printWriter) {
		String columnType = column.getColumnType();
		printWriter.print("  private "+typeConvert.convertMySqlToJava(columnType)+" ");		
		String columnName = column.getColumnName();
		printWriter.print(columnName + ";\r\n");		
		
	}
	/**
	 * ========================================================================================
	 * generateFieldMethods: 产生get和set方法的入口出
	 * @param columns
	 * @param printWriter
	 * =======================================================================================
	 */
	private void generateFieldMethods(Set<Column> columns,PrintWriter printWriter) {	
		columns.stream().sorted(Comparator.comparing(Column::getSerial)).forEach(column->generateGetAndSetMethodForField(column, printWriter));		
	}
	
	/**
	 * ========================================================================================
	 * generateGetAndSetMethodForField: 根据列名产生get和set方法
	 * @param columnName
	 * @param printWriter
	 * =======================================================================================
	 */
	private void generateGetAndSetMethodForField(Column column, PrintWriter printWriter) {
		String columnName = column.getColumnName();	
		String columnType = column.getColumnType();
		String convertedType = typeConvert.convertMySqlToJava(columnType);
		String caputreColumnName = Utils.captureName(columnName);
		printWriter.println("\r\n");
		printWriter.println("  public void set"+caputreColumnName+"("+convertedType+" "+columnName+"){");
		printWriter.println("    this."+columnName+" = "+columnName+";");
		printWriter.println("  }");
		printWriter.println("\r\n");
		printWriter.println("  public "+convertedType+" get"+caputreColumnName+"(){");
		printWriter.println("    return this."+columnName+";");
		printWriter.println("  }");
		
	}

	public Set<Table> getTables() {
		return Collections.unmodifiableSet(tables);
	}
	/**
	 * 查看表中的主键数量，主键数量为1则返回true,主键数量超过1则返回false
	 * @param table
	 * @return
	 */
	private boolean countOfPrimaryKeys(String tableName) {
		return getTables().stream().filter(tb->tb.getTableName().equals(tableName)).map(Table::getCountOfPrimaryKey)
		.findFirst().get() == 1 ? true:false;
	}
	
}
