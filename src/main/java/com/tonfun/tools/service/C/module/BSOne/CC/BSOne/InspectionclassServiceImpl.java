package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IInspectionclassDao;
import com.tonfun.tools.Model.BSOne.Inspectionclass;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IInspectionclassService;



@Service
public class InspectionclassServiceImpl extends CGenericSysImpl<Inspectionclass, Long> implements IInspectionclassService {
  private static final Logger LOGGER = LoggerFactory.getLogger(InspectionclassServiceImpl.class);
  @Autowired
  IInspectionclassDao inspectionclassDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyInspectionclass (Long id,Inspectionclass inspectionclass) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Inspectionclass preinspectionclass=inspectionclassDao.findById(id);
      preinspectionclass=inspectionclass;
      inspectionclassDao.update(preinspectionclass);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
