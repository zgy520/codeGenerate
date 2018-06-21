package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialclassDao;
import com.tonfun.tools.Model.BSOne.Materialclass;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IMaterialclassService;



@Service
public class MaterialclassServiceImpl extends CGenericSysImpl<Materialclass, Long> implements IMaterialclassService {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialclassServiceImpl.class);
  @Autowired
  IMaterialclassDao materialclassDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyMaterialclass (Long id,Materialclass materialclass) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Materialclass prematerialclass=materialclassDao.findById(id);
      prematerialclass=materialclass;
      materialclassDao.update(prematerialclass);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
