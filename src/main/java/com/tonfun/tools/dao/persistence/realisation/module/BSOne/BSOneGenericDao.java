package com.tonfun.tools.dao.persistence.realisation.module.BSOne;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tonfun.tools.dao.persistence.realisation.CCQueryDao;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年6月16日 下午9:59:50
*/
public class BSOneGenericDao<T,ID extends Serializable> extends CCQueryDao<T, ID> implements IBSOneGenericDao<T, ID> {

	@PersistenceContext(name="bsOneEntityManagerFactory",unitName="bsOne")
	@Resource(name="bsOneEntityManagerFactory")
	protected EntityManager bsOneManager;
	@Override
	public EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return this.bsOneManager;
	}
}
