package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IMaterialspecDao;
import com.tonfun.tools.Model.BSOne.Materialspec;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IMaterialspecService;



@Service
public class MaterialspecServiceImpl extends CGenericSysImpl<Materialspec, Long> implements IMaterialspecService {
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialspecServiceImpl.class);
  @Autowired
  IMaterialspecDao materialspecDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyMaterialspec (Long id,Materialspec materialspec) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Materialspec prematerialspec=materialspecDao.findById(id);
      prematerialspec=materialspec;
      materialspecDao.update(prematerialspec);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
