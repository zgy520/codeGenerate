package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IFoamrecordDao;
import com.tonfun.tools.Model.BSOne.Foamrecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IFoamrecordService;



@Service
public class FoamrecordServiceImpl extends CGenericSysImpl<Foamrecord, Long> implements IFoamrecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(FoamrecordServiceImpl.class);
  @Autowired
  IFoamrecordDao foamrecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyFoamrecord (Long id,Foamrecord foamrecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Foamrecord prefoamrecord=foamrecordDao.findById(id);
      prefoamrecord=foamrecord;
      foamrecordDao.update(prefoamrecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
