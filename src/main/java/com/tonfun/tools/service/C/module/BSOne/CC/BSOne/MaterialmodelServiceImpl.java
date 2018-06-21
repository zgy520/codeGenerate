package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialmodelDao;
import com.tonfun.tools.Model.BSOne.Materialmodel;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IMaterialmodelService;



@Service
public class MaterialmodelServiceImpl extends CGenericSysImpl<Materialmodel, Long> implements IMaterialmodelService {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialmodelServiceImpl.class);
  @Autowired
  IMaterialmodelDao materialmodelDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyMaterialmodel (Long id,Materialmodel materialmodel) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Materialmodel prematerialmodel=materialmodelDao.findById(id);
      prematerialmodel=materialmodel;
      materialmodelDao.update(prematerialmodel);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
