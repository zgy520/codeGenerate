package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ICoppersheetcorrosionrecordDao;
import com.tonfun.tools.Model.BSOne.Coppersheetcorrosionrecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ICoppersheetcorrosionrecordService;



@Service
public class CoppersheetcorrosionrecordServiceImpl extends CGenericSysImpl<Coppersheetcorrosionrecord, Long> implements ICoppersheetcorrosionrecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(CoppersheetcorrosionrecordServiceImpl.class);
  @Autowired
  ICoppersheetcorrosionrecordDao coppersheetcorrosionrecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyCoppersheetcorrosionrecord (Long id,Coppersheetcorrosionrecord coppersheetcorrosionrecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Coppersheetcorrosionrecord precoppersheetcorrosionrecord=coppersheetcorrosionrecordDao.findById(id);
      precoppersheetcorrosionrecord=coppersheetcorrosionrecord;
      coppersheetcorrosionrecordDao.update(precoppersheetcorrosionrecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
