package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IFlashrecordDao;
import com.tonfun.tools.Model.BSOne.Flashrecord;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IFlashrecordService;



@Service
public class FlashrecordServiceImpl extends CGenericSysImpl<Flashrecord, Long> implements IFlashrecordService {
  private static final Logger LOGGER = LoggerFactory.getLogger(FlashrecordServiceImpl.class);
  @Autowired
  IFlashrecordDao flashrecordDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyFlashrecord (Long id,Flashrecord flashrecord) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Flashrecord preflashrecord=flashrecordDao.findById(id);
      preflashrecord=flashrecord;
      flashrecordDao.update(preflashrecord);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
