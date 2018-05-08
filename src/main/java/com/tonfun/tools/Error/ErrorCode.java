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
**  文件名: ErrorCode.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年4月26日 下午9:33:04
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.Error;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public abstract class ErrorCode {
	protected ErrCode errCode;  //错误代码
	protected String errMsg;  //错误信息
	
	public ErrorCode() {
		this.errCode = ErrCode.SUCCESS;
		this.errMsg = "操作成功";
	}
	
	
	
	public String toString() {
		String errorMessage = String.format("当前操作的错误代码为:%s,错误提示为:%s", this.errCode.toString(),this.errMsg);
		return errorMessage;
	}



	/** ========================================================================================
	 * getErrCode: 
	 * @return errCode
	 * =======================================================================================*/
	public ErrCode getErrCode() {
		return errCode;
	}



	/** ========================================================================================
	 * setErrCode: 
	 * @param errCode 要设置的 errCode
	 * =======================================================================================*/
	public void setErrCode(ErrCode errCode) {
		this.errCode = errCode;
	}



	/** ========================================================================================
	 * getErrMsg: 
	 * @return errMsg
	 * =======================================================================================*/
	public String getErrMsg() {
		return errMsg;
	}



	/** ========================================================================================
	 * setErrMsg: 
	 * @param errMsg 要设置的 errMsg
	 * =======================================================================================*/
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
