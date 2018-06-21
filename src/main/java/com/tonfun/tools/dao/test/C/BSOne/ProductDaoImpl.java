package com.tonfun.tools.dao.test.C.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Repository;
import com.tonfun.tools.dao.persistence.realisation.module.BSOne.BSOneGenericDao;
import com.tonfun.tools.Model.BSOne.Product;
import com.tonfun.tools.dao.test.I.BSOne.IProductDao;



@Repository
public class ProductDaoImpl extends BSOneGenericDao<Product, Long> implements IProductDao {
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductDaoImpl.class);
}
