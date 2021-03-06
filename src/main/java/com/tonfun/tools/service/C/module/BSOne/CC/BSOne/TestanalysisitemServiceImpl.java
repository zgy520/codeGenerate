package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ITestanalysisitemDao;
import com.tonfun.tools.Model.BSOne.Testanalysisitem;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ITestanalysisitemService;



@Service
public class TestanalysisitemServiceImpl extends CGenericSysImpl<Testanalysisitem, Long> implements ITestanalysisitemService {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestanalysisitemServiceImpl.class);
  @Autowired
  ITestanalysisitemDao testanalysisitemDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyTestanalysisitem (Long id,Testanalysisitem testanalysisitem) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Testanalysisitem pretestanalysisitem=testanalysisitemDao.findById(id);
      pretestanalysisitem=testanalysisitem;
      testanalysisitemDao.update(pretestanalysisitem);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
