package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ITestanalysisdetailDao;
import com.tonfun.tools.Model.BSOne.Testanalysisdetail;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ITestanalysisdetailService;



@Service
public class TestanalysisdetailServiceImpl extends CGenericSysImpl<Testanalysisdetail, Long> implements ITestanalysisdetailService {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestanalysisdetailServiceImpl.class);
  @Autowired
  ITestanalysisdetailDao testanalysisdetailDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyTestanalysisdetail (Long id,Testanalysisdetail testanalysisdetail) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Testanalysisdetail pretestanalysisdetail=testanalysisdetailDao.findById(id);
      pretestanalysisdetail=testanalysisdetail;
      testanalysisdetailDao.update(pretestanalysisdetail);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
