/*
** TONFUN CONFIDENTIAL AND PROPRIETARY.
**
** This source is the sole property of Tonfun CO.,Ltd. Reproduction or Utilization of this source
** in whole or in part is forbidden without the written consent of Tonfun CO.,Ltd.
** ���ļ�����Ȩ�������ͬ����Ϣ�������޹�˾���С�
** δ�����ͬ����Ϣ�������޹�˾����ͬ�⣬�Ͻ��Դ��ļ���ȫ���򲿷ֽ��и��ƻ�ʹ�á�
**
** Tonfun CONFIDENTIAL.
** Copyright 2011-2018 Tonfun Corporation All Rights Reserved.
** ���ͬ����Ϣ�������޹�˾���ܡ�
** Copyright 2011-2018 ���ͬ����Ϣ�������޹�˾��������Ȩ����
**--------------------------------------------------------------------------------------------------
**
**  �ļ���: HelloController.java
**  ��  ��: 
**  ��  ��: a4423
**  ʱ  ��: 2018��4��23�� ����8:27:35
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonfun.tools.dao.DataBaseRepository;


/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
@RestController
public class HelloController {
	private final static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
	@Autowired
	DataBaseRepository databaseRepository;
	
	
	@RequestMapping("/")
	public String index() throws Exception {
		LOGGER.debug("This is a debug message");
		LOGGER.info("测试Logger");
		LOGGER.warn("this is a warn message");
		LOGGER.error("This is a error Message");
		//databaseRepository.getMeta();
		
		return "Greetings from Spring boot!";
	}
	@RequestMapping("/prod")
	public String getProd() {
		
		return "获取到的产品名称为:";
		
	}
}
