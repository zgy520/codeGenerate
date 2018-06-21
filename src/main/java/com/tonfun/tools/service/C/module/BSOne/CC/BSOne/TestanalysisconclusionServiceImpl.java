package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.ITestanalysisconclusionDao;
import com.tonfun.tools.Model.BSOne.Testanalysisconclusion;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ITestanalysisconclusionService;



@Service
public class TestanalysisconclusionServiceImpl extends CGenericSysImpl<Testanalysisconclusion, Long> implements ITestanalysisconclusionService {
  private static final Logger LOGGER = LoggerFactory.getLogger(TestanalysisconclusionServiceImpl.class);
  @Autowired
  ITestanalysisconclusionDao testanalysisconclusionDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyTestanalysisconclusion (Long id,Testanalysisconclusion testanalysisconclusion) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Testanalysisconclusion pretestanalysisconclusion=testanalysisconclusionDao.findById(id);
      pretestanalysisconclusion=testanalysisconclusion;
      testanalysisconclusionDao.update(pretestanalysisconclusion);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
