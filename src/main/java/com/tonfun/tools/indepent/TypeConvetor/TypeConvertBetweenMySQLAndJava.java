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
**  文件名: TypeConvertBetweenMySQLAndJava.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年4月27日 下午8:34:02
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.indepent.TypeConvetor;

import javassist.NotFoundException;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class TypeConvertBetweenMySQLAndJava implements TypeConvert {
		

	/** ========================================================================================
	 * convertMySqlToJava: 根据mysql的数据类型转换为java的数据类型 
	 * @param type
	 * @return
	 * @see com.tonfun.tools.indepent.TypeConvetor.TypeConvert#convertMySqlToJava(java.lang.String)
	 * =======================================================================================*/
	@Override
	public String convertMySqlToJava(String type) {
		// TODO Auto-generated method stub
		String result = "";
		if (type.contains("char")) {
			result = "String";
		}else if (type.contains("datetime")) {
			result = "LocalDateTime";
		}else if (type.contains("bigint")) {
			result = "Long";
		}else if (type.contains("int")) {
			result = "int";
		}else if (type.contains("tinyint")) {
			result = "boolean";
		}else if (type.contains("date")) {
			result = "LocalDate";
		}else if (type.contains("float")) {
			result = "float";
		}else if (type.contains("decimal") || type.contains("double")) {
			result = "double";
		}else if (type.contains("time")) {
			result = "LocalTime";
		}
		else {
			try {
				throw new NotFoundException("没有为Mysql中的类型："+type+"找到合适的转换类型选项，请联系管理人员!");
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				System.err.println("没有合适的转换项，请仔细检查");
				e.printStackTrace();
			}
		}
		return result;
	}
}
