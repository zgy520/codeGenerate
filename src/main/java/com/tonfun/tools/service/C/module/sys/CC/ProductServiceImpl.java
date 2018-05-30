package com.tonfun.tools.service.C.module.sys.CC;


import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import com.tonfun.tools.Model.Product;
import com.tonfun.tools.service.I.module.sys.CI.IProductService;



@Service
public class ProductServiceImpl extends CGenericSysImpl<Product, Long> implements IProductService {

}
