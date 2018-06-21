package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IPositionDao;
import com.tonfun.tools.Model.BSOne.Position;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IPositionService;



@Service
public class PositionServiceImpl extends CGenericSysImpl<Position, Long> implements IPositionService {
  private static final Logger LOGGER = LoggerFactory.getLogger(PositionServiceImpl.class);
  @Autowired
  IPositionDao positionDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyPosition (Long id,Position position) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Position preposition=positionDao.findById(id);
      preposition=position;
      positionDao.update(preposition);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
