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
**  文件名: GenerateModelFile.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月24日 下午9:38:40
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.File.C;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.dao.util.Column;
import com.tonfun.tools.dao.util.DatabaseMeta;
import com.tonfun.tools.dao.util.ForeginKey;
import com.tonfun.tools.dao.util.ManyToManyRelation;
import com.tonfun.tools.dao.util.Table;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.Utils;
import com.tonfun.tools.helper.method.GenericMethodOuput;
import com.tonfun.tools.helper.method.MethodInfo;
import com.tonfun.tools.indepent.TypeConvetor.TypeConvertBetweenMySQLAndJava;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class GenerateModelFile extends GenerateJavaFile {

	private static Map<String, ManyToManyRelation> keyManyRelations;
	
	static {
		keyManyRelations = DatabaseMeta.getKeyManyRelations();
	}
	/** ========================================================================================
	 * 构造函数
	 * @param schemaTables
	 * @param fileOperator
	 * @param typeConvert
	 * =======================================================================================*/
	public GenerateModelFile(Set<Table> schemaTables, FileOperator fileOperator) {
		super(schemaTables, fileOperator, new TypeConvertBetweenMySQLAndJava(),FileGeneratorType.Model);
		// TODO Auto-generated constructor stub
	}
	/** ========================================================================================
	 * outputReferencePackgaes: 
	 * @see com.tonfun.tools.File.C.GenerateJavaFile#outputReferencePackgaes()
	 * =======================================================================================*/
	@Override
	protected void outputReferencePackgaes() {
		// TODO Auto-generated method stub
		super.outputReferencePackgaes();
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
				"import javax.persistence.OneToMany;\r\n"+
				"import com.tonfun.tools.Auditing.hibernate.AuditListener;\r\n"+
				"import com.fasterxml.jackson.annotation.JsonIgnore;\r\n"+
				"import javax.persistence.ManyToMany;\r\n" + 
				"import javax.persistence.JoinTable;\r\n"+
				"import javax.persistence.EntityListeners;\r\n");
		printWriter.println("\r\n\r\n\r\n");
	}

	/** ========================================================================================
	 * outputClassAnnotation: 
	 * @see com.tonfun.tools.File.C.GenerateJavaFile#outputClassAnnotation()
	 * =======================================================================================*/
	@Override
	protected void outputClassAnnotation(Table table) {
		// TODO Auto-generated method stub
		this.printWriter.println("@Entity");
		this.printWriter.println("@EntityListeners(AuditListener.class)");
		this.printWriter.println("@Table(name=\""+table.getTableName()+"\")");
		//this.printWriter.println("@JsonIgnoreProperties(value={\"hibernateLazyInitializer\",\"handler\",\"fieldHandler\"})");
		this.printWriter.println("//对应的表为:"+table.getTableName());
	}

	/** ========================================================================================
	 * outputClassContent: 
	 * @param table
	 * @see com.tonfun.tools.File.C.GenerateJavaFile#outputClassContent(com.tonfun.tools.dao.util.Table)
	 * =======================================================================================*/
	@Override
	protected void outputClassContent() {
		// TODO Auto-generated method stub
		super.outputClassContent();
		Table table = this.curOperateTable;
		Set<Column> columns = table.getColumns();
		columns.stream().sorted(Comparator.comparing(Column::getSerial))
				.forEach(column->{
					if (column.isPrimaryKey()) {
						printWriter.println("  @Id");
						printWriter.println("  @GeneratedValue(strategy=GenerationType.IDENTITY)");
						printWriter.println("  private Long "+column.getColumnName()+";");
					}else {
						if (!column.isForeginKey()) {
							printWriter.println("  //"+column.getColumnType() + " " + column.getColumnComment());
							if (!column.isNull()) {  //判断是否可为空，如果为空，则不做处理，否则增加@notNull注解
								printWriter.println("  @NotNull");
							}
							checkTypeAndOutput(column, printWriter);
						}										
					}
				});		
		generateForeginContents(table, printWriter);
		generateFieldMethods(columns, printWriter);
		// 产生关系实体的get和set方法
		generateGetAndSetForRelationField(table, printWriter);
		GenericMethodOuput methodOuput = new GenericMethodOuput(this.printWriter);
		// 产生toString方法
		methodOuput.setMethodInfo(this.outputStrMethod());
		methodOuput.outputMethod();
		//this.outputStrMethod();
		// 产生静态字段
		this.outputStaticFields();
		//重载Equals方法
		methodOuput.setMethodInfo(this.outputEqualsMethod());
		methodOuput.outputMethod();
		//重载hashCode方法
		methodOuput.setMethodInfo(this.outputHashCode());
		methodOuput.outputMethod();
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
				printWriter.println("  @JsonIgnore");
				printWriter.println("  private "+Utils.captureName(foreginKey.getReferencedTableName())+
						"  "+foreginKey.getReferencedTableName().toLowerCase()+";\r\n");
			}		
		});
		/**
		 * 添加一对多的关系
		 */
		table.getAniForeginKeys().stream().forEach(aniForeginKey->{
			if (this.countOfPrimaryKeys(aniForeginKey.getTableName()) && !aniForeginKey.getTableName().equals(aniForeginKey.getReferencedTableName())) {
				printWriter.println("  @OneToMany(mappedBy = \""+aniForeginKey.getReferencedTableName().toLowerCase()+"\")");
				printWriter.println("  @JsonIgnore");
				printWriter.println("  private Set<"+Utils.captureName(aniForeginKey.getTableName())+
						">  "+aniForeginKey.getTableName().toLowerCase()+"s = new HashSet<>();\r\n");
			}
		});
		/**
		 * 添加多对多的关系
		 */
		keyManyRelations.forEach((key,value)->{
			if (key.contains(table.getTableName())) {
				printWriter.println("  @ManyToMany(fetch=FetchType.LAZY)");
				printWriter.print("  @JoinTable(name=\""+value.getCurTableName()+"\"" +
									",joinColumns = {@JoinColumn(name=\"");
				String CurcolumnName = "";
				String OtherColumnName = "";
				String tableName = "";
				if (value.getPrimaryTableName().equals(table.getTableName())) {
					CurcolumnName = value.getPrimaryColumnName();
					OtherColumnName = value.getMiniorColumnName();
					tableName = value.getMiniorTableName();
				}else {
					CurcolumnName = value.getMiniorColumnName();
					OtherColumnName = value.getPrimaryColumnName();
					tableName = value.getPrimaryTableName();
				}
				printWriter.print(CurcolumnName+"\")},"
						+ "inverseJoinColumns = {@JoinColumn(name=\""+
						OtherColumnName+"\")})\r\n");
				printWriter.println("  @JsonIgnore");
				printWriter.println("  private Set<"+Utils.captureName(tableName)+"> " 
									+value.getCurTableName() + "_" + tableName+"s;");
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
			if (this.countOfPrimaryKeys(foreginKey.getReferencedTableName()) && !foreginKey.getTableName().equals(foreginKey.getReferencedTableName())) {  // 如果表明和应用的表明一样，则不做处理
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
			if (this.countOfPrimaryKeys(aniForeginKey.getTableName()) && !aniForeginKey.getTableName().equals(aniForeginKey.getReferencedTableName())) {
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
		/**
		 * 添加多对多的关系
		 */
		keyManyRelations.forEach((key,value)->{
			if (key.contains(table.getTableName())) {

				String tableName = "";
				if (value.getPrimaryTableName().equals(table.getTableName())) {
					tableName =Utils.captureName(value.getMiniorTableName());
				}else {
					tableName =Utils.captureName(value.getPrimaryTableName());
				}
				
				/**
				 * 填充get方法
				 */
				printWriter.println("  public Set<"+tableName+"> get"+value.getCurTableName()+"_"+tableName+"s() {");
				printWriter.println("    return this."+value.getCurTableName()+"_"+tableName.toLowerCase()+"s;");
				printWriter.println("  }\r\n");
				
				/**
				 * 填充set方法
				 */
				printWriter.println("  public void set"+value.getCurTableName()+"_"+tableName+"s(Set<"+tableName +"> "+value.getCurTableName()+"_"+tableName.toLowerCase()+"s) {");
				printWriter.println("    this."+value.getCurTableName()+"_"+tableName.toLowerCase()+"s = "+value.getCurTableName()+"_"+tableName.toLowerCase()+"s;");
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
		columns.stream().sorted(Comparator.comparing(Column::getSerial)).forEach(column->{
			if (!column.isForeginKey()) { // 仅仅为非外键字段产生get和set方法
				generateGetAndSetMethodForField(column, printWriter);
			}			
		});		
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

	/**
	 * 查看表中的主键数量，主键数量为1则返回true,主键数量超过1则返回false
	 * @param table
	 * @return
	 */
	private boolean countOfPrimaryKeys(String tableName) {
		return this.schemaTables.stream().filter(tb->tb.getTableName().equals(tableName)).map(Table::getCountOfPrimaryKey)
		.findFirst().get() == 1 ? true:false;
	}
	@Override
	protected void outputClassName(String tableName) {
		// TODO Auto-generated method stub
		this.setClassName(this.getCaptureTableName());
		this.printWriter.println("public class "+ this.getClassName() +"{");
	}
	/**
	 * 重载toString方法
	 */
	private MethodInfo outputStrMethod() {
		MethodInfo methodInfo = new MethodInfo("public ", "String ", "toString", true);
		methodInfo.setMethodContent(this.outputStringMethodContent());
		return methodInfo;
	}
	/**
	 * 重载equals方法
	 */
	private MethodInfo outputEqualsMethod() {
		MethodInfo methodInfo = new MethodInfo("public ", "boolean ", "equals", true);
		String[] argTypes = {"Object"};
		String[] argValue = {"o"};
		methodInfo.setArgsTypesList(argTypes);
		methodInfo.setArgsList(argValue);
		StringBuilder methodContent = new StringBuilder();
		methodContent.append("    if(this == o) return true;\n");
		methodContent.append("    if(!(o instanceof "+this.getCaptureTableName()+")) return false;\n");
		methodContent.append("    "+this.getCaptureTableName() +" "+this.getTableName() + "= ("+this.getCaptureTableName()+")o;\n");
		String id = this.curOperateTable.getColumns().stream().filter(colum->colum.isPrimaryKey()).map(Column::getColumnName).findFirst().get();
		methodContent.append("    return "+id+"!= null && "+id+".equals("+this.getTableName()+"."+id+");");
		methodInfo.setMethodContent(methodContent);
		
		return methodInfo;
	}
	/**
	 * 重载hashCode方法
	 */
	private MethodInfo outputHashCode() {
		MethodInfo methodInfo = new MethodInfo("public ", "int ", "hashCode", true);
		methodInfo.setMethodContent(new StringBuilder("    return 31;"));
		return methodInfo;
	}
	
	//todo 以上重载的toString,toEquals和HashCode方法可以进行重构
	//重构时，可将重复性的代码进行合并，统一处理，后续进行修改
	
	/**
	 * 输出toString方法的内容
	 */
	private StringBuilder outputStringMethodContent() {
		StringBuilder methodContent = new StringBuilder();
		
		StringBuilder paramBuilder = new StringBuilder();
		paramBuilder.append("\"");
		StringBuilder valueBuilder = new StringBuilder();
		Table table = this.curOperateTable;
		Set<Column> columns = table.getColumns();
		columns.stream().sorted(Comparator.comparing(Column::getSerial))
				.forEach(column->{
					if (!column.isForeginKey()) {
						paramBuilder.append(column.getColumnName()+"=%s,");
						valueBuilder.append("this."+column.getColumnName()+",");
					}
					
				});
		methodContent.append("    return String.format("+paramBuilder.toString().substring(0, paramBuilder.length() - 1)+"\","+ valueBuilder.toString().substring(0,valueBuilder.toString().length() - 1)+");");
		//this.printWriter.println("    return String.format("+paramBuilder.toString().substring(0, paramBuilder.length() - 1)+"\","+ valueBuilder.toString().substring(0,valueBuilder.toString().length() - 1)+");");
		return methodContent;
	}
	/**
	 * 输出静态字段
	 */
	private void outputStaticFields() {
		Table table = this.curOperateTable;
		Set<Column> columns = table.getColumns();
		columns.stream().sorted(Comparator.comparing(Column::getSerial))
				.forEach(column->{
					if (!column.isForeginKey()) {
						this.printWriter.println("  private final static String FIELD_"+
							column.getColumnName().toUpperCase() + "=\""+
							column.getColumnName()+"\";");
						this.printWriter.println("  public static String getField"+column.getColumnName()+
												"() {");
						this.printWriter.println("    return FIELD_"+column.getColumnName().toUpperCase()+";");
						this.printWriter.println("  }\r\n");
					}
				});	
	}
}
