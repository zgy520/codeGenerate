package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IWatersampleDao;
import com.tonfun.tools.Model.BSOne.Watersample;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IWatersampleService;



@Service
public class WatersampleServiceImpl extends CGenericSysImpl<Watersample, Long> implements IWatersampleService {
  private static final Logger LOGGER = LoggerFactory.getLogger(WatersampleServiceImpl.class);
  @Autowired
  IWatersampleDao watersampleDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyWatersample (Long id,Watersample watersample) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Watersample prewatersample=watersampleDao.findById(id);
      prewatersample=watersample;
      watersampleDao.update(prewatersample);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
