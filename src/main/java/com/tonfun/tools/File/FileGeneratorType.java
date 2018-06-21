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
**  文件名: FiileGeneratorType.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月18日 下午9:00:43
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.File;

/** ========================================================================================
 * @author a4423
 * 文件产生器的类型
 * =======================================================================================*/
public enum FileGeneratorType {
	Model,  // 模型文件
	DaoInterface, // dao层的接口文件
	DaoImpl, // dao层的实现文件
	ServiceInterface, //service层的接口文件
	ServiceImpl,  //serivce层的实现文件
	Controller,   // controller类的文件
}
