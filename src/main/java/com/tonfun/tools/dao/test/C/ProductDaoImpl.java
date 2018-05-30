package com.tonfun.tools.dao.test.C;


import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.sys.SystemGenericDao;
import com.tonfun.tools.Model.Product;
import com.tonfun.tools.dao.test.I.IProductDao;



@Repository
public class ProductDaoImpl extends SystemGenericDao<Product, Long> implements IProductDao {

}
