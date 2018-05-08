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
**  文件名: Utils.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年4月26日 下午9:49:45
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.helper;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class Utils {
	/**
	 * ========================================================================================
	 * captureName:首字母大写 
	 * @param str
	 * @return
	 * =======================================================================================
	 */
	public static String captureName(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(str.substring(0, 1).toLowerCase());
		stringBuilder.append(str.substring(1));
		char[] cs = stringBuilder.toString().toCharArray();		
		cs[0]-=32;
		return String.valueOf(cs);
	}
}
