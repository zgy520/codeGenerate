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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonfun.tools.dao.DataBaseRepository;
import com.tonfun.tools.dao.persistence.pagination.Pagination;
import com.tonfun.tools.dao.persistence.pagination.SortOrder;
import com.tonfun.tools.dao.persistence.pagination.Pagination.PaginationBuilder;
import com.tonfun.tools.dao.test.BtnDao;
import com.tonfun.tools.model.Product;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
@RestController
public class HelloController {
	@Autowired
	DataBaseRepository databaseRepository;
	
	@Autowired
	BtnDao btnDao;
	
	@RequestMapping("/")
	public String index() throws Exception {
		//databaseRepository.getMeta();
		/*System.out.println("获取到的产品的数量为:"+btnDao.findAll().size()+"个");
		Product product = new Product();
		product.setBrandID(1L);
		product.setModelID(1L);
		product.setSpecID(1l);
		product.setUnitID(1L);
		product.setProdName("新添加的产品名称");
		product.setSpecifications("170HK");
		btnDao.save(product);
		System.out.println("prodID 231 对应的产品名称为:"+btnDao.findById(product.getProdID()).getProdName());*/	
		Pagination<Product> paginationForProduct = new Pagination.PaginationBuilder<Product>(8, 1)
							.setOrderBy(SortOrder.DESC).setOrderField("prodName").build();
		paginationForProduct = btnDao.paginationByCriteria(paginationForProduct);
		paginationForProduct.getListData().stream().forEach(product->{
			System.out.println(product.getProdName());
		});
		System.out.println("获取到的数据的总条数为:"+paginationForProduct.getTotalRecords()+",总页数为："
						+ paginationForProduct.getTotalPages());
		return "Greetings from Spring boot!";
	}
}
