package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IStorehouseDao;
import com.tonfun.tools.Model.BSOne.Storehouse;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IStorehouseService;



@Service
public class StorehouseServiceImpl extends CGenericSysImpl<Storehouse, Long> implements IStorehouseService {
  private static final Logger LOGGER = LoggerFactory.getLogger(StorehouseServiceImpl.class);
  @Autowired
  IStorehouseDao storehouseDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyStorehouse (Long id,Storehouse storehouse) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Storehouse prestorehouse=storehouseDao.findById(id);
      prestorehouse=storehouse;
      storehouseDao.update(prestorehouse);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
