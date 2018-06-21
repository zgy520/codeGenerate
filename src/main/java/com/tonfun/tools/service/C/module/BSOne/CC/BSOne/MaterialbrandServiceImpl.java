package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialbrandDao;
import com.tonfun.tools.Model.BSOne.Materialbrand;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IMaterialbrandService;



@Service
public class MaterialbrandServiceImpl extends CGenericSysImpl<Materialbrand, Long> implements IMaterialbrandService {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialbrandServiceImpl.class);
  @Autowired
  IMaterialbrandDao materialbrandDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyMaterialbrand (Long id,Materialbrand materialbrand) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Materialbrand prematerialbrand=materialbrandDao.findById(id);
      prematerialbrand=materialbrand;
      materialbrandDao.update(prematerialbrand);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
