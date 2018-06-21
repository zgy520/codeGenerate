package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IKinematicviscositysampleDao;
import com.tonfun.tools.Model.BSOne.Kinematicviscositysample;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IKinematicviscositysampleService;



@Service
public class KinematicviscositysampleServiceImpl extends CGenericSysImpl<Kinematicviscositysample, Long> implements IKinematicviscositysampleService {
  private static final Logger LOGGER = LoggerFactory.getLogger(KinematicviscositysampleServiceImpl.class);
  @Autowired
  IKinematicviscositysampleDao kinematicviscositysampleDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyKinematicviscositysample (Long id,Kinematicviscositysample kinematicviscositysample) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Kinematicviscositysample prekinematicviscositysample=kinematicviscositysampleDao.findById(id);
      prekinematicviscositysample=kinematicviscositysample;
      kinematicviscositysampleDao.update(prekinematicviscositysample);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
