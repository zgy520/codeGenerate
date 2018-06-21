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
import javax.persistence.PostUpdate;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tonfun.tools.Model.sys.Log;
import com.tonfun.tools.Model.sys.Log_content;
import com.tonfun.tools.helper.Utils;
import com.tonfun.tools.helper.NoSpringContext.AutowireHelper;
import com.tonfun.tools.service.I.module.sys.CI.sys.ILogService;
import com.tonfun.tools.service.I.module.sys.CI.sys.ILog_contentService;

/** ========================================================================================
 * @author a4423
 * 操作日志监听器
 * =======================================================================================*/
public class AuditListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuditListener.class);
	@Autowired
	ILogService logService;
	@Autowired
	ILog_contentService logContentService;
	
	@PreRemove
	private void beforeDeleteEntity(Object object) {
		LOGGER.info("删除实体之前调用");	
		Map<String, Object> map = this.getMapByObj(object);		
	}
	@PostPersist
	private void afterSaveEntity(Object object) {
		AutowireHelper.autowire(this, this.logService);
		AutowireHelper.autowire(this, this.logContentService);
		LOGGER.info("保存实体之后调用"+object.getClass().getSimpleName());
		String entityName = object.getClass().getSimpleName();
		if (entityName.equals("Log") || entityName.equals("Log_content")) {
			return;
		}
		Log log = new Log();
		log.setLoginName("zgy");
		log.setMessage("测试消息");
		log.setOperation("add");
		log.setTblName(entityName.toLowerCase());
		log.setTblComment("无");
		logService.save(log);
		Map<String, Object> map = this.getMapByObj(object);
		
		for (Map.Entry<String, Object> entry : map.entrySet()){
			if (!entry.getKey().contains("FIELD_")) {
				Log_content log_content = new Log_content();
				log_content.setFldName(entry.getKey());
				log_content.setLog(log);
				if (entry.getValue()!=null) {
					log_content.setNewValue(entry.getValue().toString());
				}
				logContentService.save(log_content);
				System.out.println(entry.getKey() + ":" + entry.getValue());
			}		    
		}
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
			
			return map;
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
