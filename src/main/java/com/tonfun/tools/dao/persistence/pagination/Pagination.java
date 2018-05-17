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
**  文件名: APagination.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年5月9日 上午8:20:52
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.dao.persistence.pagination;

import java.util.Collections;
import java.util.List;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class Pagination<T>{
	private int count;  // 每页的数量
	private int pager; // 当前的页码数
	private String orderField;  //排序字段
	private SortOrder orderBy;  //排序方式  升序还是降序
	private List<T> listData;  //数据列表
	private long totalRecords;  //总的记录数
	private int totalPages;  //共分了多少页
	
	private Pagination(PaginationBuilder<T> builder){
		this.count = builder.count;
		this.pager = builder.pager;
		this.orderField = builder.orderField;
		this.orderBy = builder.orderBy;
	}
	
	// Builder Class
	public static class PaginationBuilder<T>{
		// 必要的参数
		private int count;  // 每页的数量
		private int pager; // 当前的页码数
		// 可选的参数
		private String orderField;  //排序字段
		private SortOrder orderBy;  //排序方式  升序还是降序
		
		public PaginationBuilder(int count,int pager) {
			this.count = count;
			this.pager = pager;
		}
		
		public PaginationBuilder<T> setOrderField(String orderField) {
			this.orderField = orderField;
			return this;
		}
		public PaginationBuilder<T> setOrderBy(SortOrder orderBy) {
			this.orderBy = orderBy;
			return this;
		}
		
		public Pagination<T> build() {
			return new Pagination<T>(this);
		}
	}
		
	/** ========================================================================================
	 * getPager: 
	 * @return pager
	 * =======================================================================================*/
	public int getPager() {
		return pager;
	}
	/** ========================================================================================
	 * setPager: 
	 * @param pager 要设置的 pager
	 * =======================================================================================*/
	public void setPager(int pager) {
		this.pager = pager;
	}
	
	/** ========================================================================================
	 * getOrderField: 
	 * @return orderField
	 * =======================================================================================*/
	public String getOrderField() {
		return orderField;
	}
	/** ========================================================================================
	 * setOrderField: 
	 * @param orderField 要设置的 orderField
	 * =======================================================================================*/
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	/** ========================================================================================
	 * getOrderBy: 
	 * @return orderBy
	 * =======================================================================================*/
	public SortOrder getOrderBy() {
		return orderBy;
	}
	/** ========================================================================================
	 * setOrderBy: 
	 * @param orderBy 要设置的 orderBy
	 * =======================================================================================*/
	public void setOrderBy(SortOrder orderBy) {
		this.orderBy = orderBy;
	}
	/** ========================================================================================
	 * getCount: 
	 * @return count
	 * =======================================================================================*/
	public int getCount() {
		return count;
	}
	/** ========================================================================================
	 * setCount: 
	 * @param count 要设置的 count
	 * =======================================================================================*/
	public void setCount(int count) {
		this.count = count;
	}
	/** ========================================================================================
	 * getListData: 
	 * @return listData
	 * =======================================================================================*/
	public List<T> getListData() {
		return Collections.unmodifiableList(listData);
	}
	
	
	/** ========================================================================================
	 * setListData: 
	 * @param listData 要设置的 listData
	 * =======================================================================================*/
	public void setListData(List<T> listData) {
		this.listData = listData;		
	}
	/** ========================================================================================
	 * getTotalRecords: 
	 * @return totalRecords
	 * =======================================================================================*/
	public long getTotalRecords() {
		return totalRecords;
	}
	/** ========================================================================================
	 * getTotalPages: 
	 * @return totalPages
	 * =======================================================================================*/
	public int getTotalPages() {
		return totalPages;
	}
	/** ========================================================================================
	 * setTotalRecords: 
	 * @param totalRecords 要设置的 totalRecords
	 * =======================================================================================*/
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
		int totalPages = (int)((totalRecords / this.getCount())+1);
		this.totalPages = totalPages;
	}	
	
}
