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
**  文件名: AuditListener.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月30日 下午8:20:17
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.Auditing.hibernate;

import java.util.Map;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.tonfun.tools.helper.Utils;

/** ========================================================================================
 * @author a4423
 * 操作日志监听器
 * =======================================================================================*/
public class AuditListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuditListener.class);
	
	@PreRemove
	private void beforeDeleteEntity(Object object) {
		LOGGER.info("删除实体之前调用");	
		Map<String, Object> map = this.getMapByObj(object);		
	}
	@PostPersist
	private void afterSaveEntity(Object object) {
		LOGGER.info("保存实体之后调用");		
		Map<String, Object> map = this.getMapByObj(object);
		
	}
	@PreUpdate
	private void beforeUpdateEntity(Object object) {
		LOGGER.info("更新实体之前调用");
		Map<String, Object> map = this.getMapByObj(object);
		
	}
	@PostUpdate
	private void afterUpdateEntity(Object object) {
		LOGGER.info("更新实体之后调用");
		Map<String, Object> map = this.getMapByObj(object);
		
	}
	
	private Map<String, Object> getMapByObj(Object object){
		try {
			Map<String,Object> map = Utils.getFields(object, false);
			for (Map.Entry<String, Object> entry : map.entrySet()){
			    System.out.println(entry.getKey() + ":" + entry.getValue());
			}
			return map;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
