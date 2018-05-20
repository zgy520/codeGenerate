package com.tonfun.tools.service.I;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tonfun.tools.dao.persistence.pagination.Pagination;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年5月20日 下午3:14:46
*/
public interface IGenericService<T,ID extends Serializable> {
	T findById(ID id);  // 根据id获取对象
	List<T> findAll();  //返回所有的实体信息
	T save(T entity);  // 保存对象
	void update(T entity);  // 更新对象
	void delete(T entity);  // 删除对象
	void deleteById(ID id); // 根据id删除对象
	void saveOrUpdate(T t);  // 更新或者保存
	
	Pagination<T> queryByPagination(Pagination<T> pagination);  // 根据分页进行查询
	Pagination<T> paginationByCriteria(Pagination<T> pagination);  // 根据Criteria API 进行分页查询	
	Pagination<T> paginationByScrollableReslt(Pagination<T> pagination); // 根据ScrollableResults API进行分页查询
	List<T> getObjListByColumnName(String columnName,String columnVal);  //根据列名和列值获取实体的集合
	List<T> getObjListByColMap(Map<String, String> colVals);  //根据列和值的集合获取实体的集合
	List<T> getObjListByLike(String columnName,String colmnVal);  //like查询
	Pagination<T> getPagingObjListByQuery(Pagination<T> pagination,String whereClause);  //根据sql语句查询对象列表
	List<T> getObjListByQuery(String sqlQuery); // 根据查询条件查询对象列表
}
