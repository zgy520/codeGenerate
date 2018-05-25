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
**  文件名: FileGeneratorFactory.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月18日 下午8:51:14
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.File;

import java.util.Optional;
import java.util.Set;

import com.tonfun.tools.File.C.GenerateDaoJavaFile;
import com.tonfun.tools.File.C.GenerateServiceImplFile;
import com.tonfun.tools.File.C.GenerateServiceInterfaceFile;
import com.tonfun.tools.File.I.FileGeneratorInterface;
import com.tonfun.tools.dao.util.Table;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.OutputStyle;
import com.tonfun.tools.helper.xml.XmlParserFactory;

/** ========================================================================================
 * @author a4423
 * 文件产生工厂
 * =======================================================================================*/
public class FileGeneratorFactory {
	private static FileOperator fileOperator;	
	static {
		fileOperator = new FileOperator(OutputStyle.Default);		
	}
	public void setFileOperator(OutputStyle outputStyle) {
		fileOperator = new FileOperator(outputStyle);
	}	
	/**
	 * ========================================================================================
	 * getFileGenerator:根据产生的文件类型返回相应的实现类 
	 * @param generatorType  产生文件的类型，如model类型、dao层中的接口和实现类或者service层的接口或实现类
	 * @param tables  产生的文件中对应的所有表的结构信息
	 * @return
	 * =======================================================================================
	 */
	public static FileGeneratorModel getFileGenerator(FileGeneratorType generatorType,Set<Table> tables) {
		FileGeneratorInterface fileGeneratorInterface = null;
		if (generatorType==FileGeneratorType.Model) {  // 获取产生实体类型的文件所对应的处理类
			//fileGeneratorInterface = new GenerateModelJavaFile(tables);			
		}else if (generatorType==FileGeneratorType.DaoInterface) { // 获取产生dao层接口类型的文件所对应的处理类
			//fileGeneratorInterface = new GenerateDaoInterfaceFile();
		}else if (generatorType==FileGeneratorType.DaoImpl) { // 获取产生dao层实现类型的文件所对应的处理类
			fileGeneratorInterface = new GenerateDaoJavaFile();
		}else if (generatorType==FileGeneratorType.ServiceInterface) { // 获取产生service层接口类型的文件所对应的处理类
			fileGeneratorInterface = new GenerateServiceInterfaceFile();
		}else if (generatorType==FileGeneratorType.ServiceImpl) { // 获取产生service层实现类类型的文件所对应的处理类
			fileGeneratorInterface = new GenerateServiceImplFile();
		}
		fileOperator.setPackageName(Optional.of(XmlParserFactory.getXmlParser().xmlParser(generatorType,"packageName")));
		FileGeneratorModel fileGeneratorModel = new FileGeneratorModel(fileGeneratorInterface, fileOperator);
		return fileGeneratorModel;
	}
}
