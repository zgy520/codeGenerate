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
**  文件名: FileGeneratorModel.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月18日 下午9:12:29
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.File;

import com.tonfun.tools.File.I.FileGeneratorInterface;
import com.tonfun.tools.helper.FileOperator;

/** ========================================================================================
 * @author a4423
 * 构造一个实体类，用于记录文件产生器类和FileOperator(文件产生的基本信息）
 * =======================================================================================*/
public class FileGeneratorModel {
	private FileGeneratorInterface fileGeneratorInterface;
	private FileOperator fileOperator;
	public FileGeneratorModel(FileGeneratorInterface fileGeneratorInterface,FileOperator fileOperator) {
		this.fileGeneratorInterface = fileGeneratorInterface;
		this.fileOperator = fileOperator;
	}
	/** ========================================================================================
	 * getFileGeneratorInterface: 
	 * @return fileGeneratorInterface
	 * =======================================================================================*/
	public FileGeneratorInterface getFileGeneratorInterface() {
		return fileGeneratorInterface;
	}
	/** ========================================================================================
	 * setFileGeneratorInterface: 
	 * @param fileGeneratorInterface 要设置的 fileGeneratorInterface
	 * =======================================================================================*/
	public void setFileGeneratorInterface(FileGeneratorInterface fileGeneratorInterface) {
		this.fileGeneratorInterface = fileGeneratorInterface;
	}
	/** ========================================================================================
	 * getFileOperator: 
	 * @return fileOperator
	 * =======================================================================================*/
	public FileOperator getFileOperator() {
		return fileOperator;
	}
	/** ========================================================================================
	 * setFileOperator: 
	 * @param fileOperator 要设置的 fileOperator
	 * =======================================================================================*/
	public void setFileOperator(FileOperator fileOperator) {
		this.fileOperator = fileOperator;
	}
}
