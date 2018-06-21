package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IKinematicviscosityrecordDao;
import com.tonfun.tools.Model.BSOne.Kinematicviscosityrecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IKinematicviscosityrecordService;



@Service
public class KinematicviscosityrecordServiceImpl extends CGenericSysImpl<Kinematicviscosityrecord, Long> implements IKinematicviscosityrecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(KinematicviscosityrecordServiceImpl.class);
  @Autowired
  IKinematicviscosityrecordDao kinematicviscosityrecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyKinematicviscosityrecord (Long id,Kinematicviscosityrecord kinematicviscosityrecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Kinematicviscosityrecord prekinematicviscosityrecord=kinematicviscosityrecordDao.findById(id);
      prekinematicviscosityrecord=kinematicviscosityrecord;
      kinematicviscosityrecordDao.update(prekinematicviscosityrecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
