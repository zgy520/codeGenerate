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
**  时  间: 2018年5月23日 下午9:28:39
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.File.C;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Set;

import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.File.I.IGenericFileGenerator;
import com.tonfun.tools.dao.util.Table;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.Utils;
import com.tonfun.tools.helper.method.methodFactory.GenericMethodFactory;
import com.tonfun.tools.helper.method.methodFactory.ModifyEntityFactory;
import com.tonfun.tools.indepent.TypeConvetor.TypeConvert;

/** ========================================================================================
 * @author a4423
 * 产生java文件的抽象类
 * =======================================================================================*/
public abstract class GenerateJavaFile implements IGenericFileGenerator {
	protected Set<Table> schemaTables; // 当前处理的数据库所对应的所有的表信息
	protected TypeConvert typeConvert;  // 类型转换
	protected FileOperator fileOperator;  // 输出文件的配置类
	protected PrintWriter printWriter;  // 输出日志文件
	protected Table curOperateTable;  // 当前正在处理的文件所对应的表
	private String tableName;  //表名
	private String captureTableName;  //转化后的类名中的表部分
	private String className;  //类名
	private final FileGeneratorType fileGeneratorType;  //当前产生的文件的类型
	private final GenericMethodFactory methodFactory;
	
	/**
	 * ========================================================================================
	 * 构造函数 根据所有的表信息和转换信息进行构造
	 * @param schemaTables
	 * @param fileoperator 用于获取所输出文件类型对应的基本信息，如输出目录，输出文件的包名等信息
	 * @param typeConvert
	 * =======================================================================================
	 */
	public GenerateJavaFile(Set<Table> schemaTables,FileOperator fileOperator,TypeConvert typeConvert,FileGeneratorType generatorType) {
		this.schemaTables = schemaTables;
		this.fileOperator = fileOperator;
		this.typeConvert = typeConvert;
		this.fileGeneratorType = generatorType;
		methodFactory = new ModifyEntityFactory(this.fileGeneratorType);
	}

	/** ========================================================================================
	 * fileGenerator: 文件产生器，产生各类文件的总入口
	 * @return
	 * @see com.tonfun.tools.File.I.IGenericFileGenerator#fileGenerator()
	 * =======================================================================================*/
	@Override
	public final ErrorCode fileGenerator() {
		// TODO Auto-generated method stub
		for(Table table : schemaTables) {
			if (table.isCreatedFile()) {  // 用于判断哪些表是需要创建文件的
				//1. 查看文件是否产生，如果没产生则产生该文件并返回printWriter对象,如果已经产生则直接返回printWriter
				this.printWriter = getPrintWriter(table.getTableName());  // 产生printWriter对象，供后续使用
				if (this.printWriter==null) { // 在获取pringWriter的过程中报错，跳过该文件的产生并继续下一个文件的产生
					continue;
				}
				this.curOperateTable = table;
				this.tableName = table.getTableName();  // 设置表名
				// 设置以下tableName和printWriter，以供产生相应的方法
				this.methodFactory.setTableName(this.tableName);
				this.methodFactory.setPrintWriter(this.printWriter);
				// 设置完毕
				this.captureTableName = Utils.captureName(this.tableName); // 设置转换后的类名
				//2. 产生包名
				this.outputPacakgeName();
				// 3. 输出引用的包名
				this.outputReferencePackgaes();
				//4. 输出类标注
				this.outputClassAnnotation(table);
				//5. 输出类名
				this.outputClassName(table.getTableName());
				//6. 产生文件的内容
				this.outputClassContent();
				//7. 类文件结束符
				
				this.outputClassEndingOperator();
				//8. 关闭文件写入对象
				this.closePrintWriter();
			}
		}
		return null;
	}	
	
	/**
	 * ========================================================================================
	 * getPrintWriter: 判断是否存在对应的文件，并返回文件写入的对象printWriter
	 * @param tableName
	 * @return
	 * =======================================================================================
	 */
	private PrintWriter getPrintWriter(String tableName) {
		String fileName =this.fileOperator.getPrefixName().trim() + Utils.captureName(tableName) + this.fileOperator.getSuffixName().trim() + ".java";  // 产生的文件名
		File file = new File(fileOperator.getPackageDir(),fileName);
		PrintWriter printWriter = null;
		try {
			if (!file.exists()) {
				file.createNewFile();				
			}			
			FileWriter fileWriter = new FileWriter(file);
			printWriter = new PrintWriter(fileWriter);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("在获取PrintWriter的过程中出现问题，错误详情如下:"+file.getName());
			e.printStackTrace();
		}
		return printWriter;
	}
	/**
	 * ========================================================================================
	 * ouputPackageName: 输出包名，根据fileOperator对象进行获取
	 * =======================================================================================
	 */
	private void outputPacakgeName() {
		this.printWriter.println("package "+fileOperator.getPackage_Name()+";");
	}
	/**
	 * ========================================================================================
	 * ouputReferencePackgaes: 输出引用的包
	 * =======================================================================================
	 */
	protected void outputReferencePackgaes() {
		// 导入日志相关的包
		if (!fileGeneratorType.equals(FileGeneratorType.DaoInterface) && !fileGeneratorType.equals(FileGeneratorType.ServiceInterface)) {
			this.printWriter.println("import org.slf4j.Logger;\r\n" + 
				"import org.slf4j.LoggerFactory;\r\n");
		}
		
	}
	/**
	 * ========================================================================================
	 * ouputClassAnnotation: 输出类标注（即类前面的一些标注信息，如@Entity,@Service等）
	 * 需要由每个具体的实现类重写该方法
	 * =======================================================================================
	 */
	protected abstract void outputClassAnnotation(Table table);
	/**
	 * ========================================================================================
	 * outputClassName: 输出类名
	 * =======================================================================================
	 */
	protected abstract void outputClassName(String tableName);
	
	/**
	 * ========================================================================================
	 * outputClassContent: 根据表的信息产生文件内容
	 * @param table
	 * =======================================================================================
	 */
	protected void outputClassContent() {
		if (!fileGeneratorType.equals(FileGeneratorType.DaoInterface) && !fileGeneratorType.equals(FileGeneratorType.ServiceInterface)) {
			this.printWriter.println("  private static final Logger LOGGER = LoggerFactory.getLogger("+
									this.getClassName()+".class);");
		}		
	}
	/**
	 * ========================================================================================
	 * outputClassEndingOperator: 输出结尾符
	 * =======================================================================================
	 */
	protected final void outputClassEndingOperator() {
		this.printWriter.println("}");
	}
	/**
	 * ========================================================================================
	 * closePrintWriter: 关闭文件的写入对象printWriter
	 * =======================================================================================
	 */
	private final void closePrintWriter() {
		this.printWriter.close();
	}

	protected String getTableName() {
		return tableName;
	}

	protected String getCaptureTableName() {
		return captureTableName;
	}

	protected String getClassName() {
		return className;
	}

	protected void setClassName(String className) {
		this.className = className;
	}

	public FileGeneratorType getFileGeneratorType() {
		return fileGeneratorType;
	}

	public GenericMethodFactory getMethodFactory() {
		return methodFactory;
	}
	
}
