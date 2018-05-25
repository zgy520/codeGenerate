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
**  文件名: GenerateDaoJavaFile.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月17日 下午9:23:35
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.File.C;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.File.I.FileGeneratorInterface;
import com.tonfun.tools.dao.util.Table;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.Utils;
import com.tonfun.tools.helper.xml.XmlParserFactory;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class GenerateServiceImplFile implements FileGeneratorInterface {	

	/** ========================================================================================
	 * generateCodeFile: 
	 * @param table
	 * @param file
	 * @return
	 * @see com.tonfun.tools.File.I.FileGeneratorInterface#generateCodeFile(com.tonfun.tools.dao.util.Table, com.tonfun.tools.helper.FileOperator)
	 * =======================================================================================*/
	@Override
	public ErrorCode generateCodeFile(Table table, FileOperator fileOperator) {
		// TODO Auto-generated method stub
		ErrorCode errorCode = new DefaultErrorCode();
		String modelName = com.tonfun.tools.helper.Utils.captureName(table.getTableName());
		File file = new File(fileOperator.getPackageDir(),modelName+"ServiceImpl.java");
		
		try {
			if (!file.exists()) {
				file.createNewFile();				
			}
			
			FileWriter fileWriter = new FileWriter(file);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("package "+fileOperator.getPackage_Name()+";");  // 产生包名
			
			outputPackage(printWriter,modelName);  //将相关的包输出
			
			// 以下两行用于在类的头部添加实体类的标识
			printWriter.println("@Service");			
			printWriter.println("public class "+Utils.captureName(table.getTableName())+"ServiceImpl" +
			" extends CGenericSysImpl<"+modelName+", Long> " + "implements I"+Utils.captureName(table.getTableName())+"Service "+
			"{\r\n");  //产生类名
			
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
	
	private void outputPackage(PrintWriter printWriter,String model) {
		printWriter.println("\r\n\r\nimport org.springframework.stereotype.Service;\r\n" + 
				"import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;\r\n" + 				
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.Model,"packageName")+"."+model+";\r\n"+
				"import "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.ServiceInterface,"packageName")+".I"+model+"Service;\r\n");
		printWriter.println("\r\n");
	};

}
