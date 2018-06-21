package com.tonfun.tools.service.C.module.BSOne.CC.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import org.springframework.stereotype.Service;
import com.tonfun.tools.service.C.module.sys.CGenericSysImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.dao.test.I.BSOne.IFoamitemDao;
import com.tonfun.tools.Model.BSOne.Foamitem;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IFoamitemService;



@Service
public class FoamitemServiceImpl extends CGenericSysImpl<Foamitem, Long> implements IFoamitemService {
  private static final Logger LOGGER = LoggerFactory.getLogger(FoamitemServiceImpl.class);
  @Autowired
  IFoamitemDao foamitemDao;

  /**
  *   修改实体的属性值
  */
  @Override
  public ErrorCode modifyFoamitem (Long id,Foamitem foamitem) {
    ErrorCode errorCode = new DefaultErrorCode();
    try {
      Foamitem prefoamitem=foamitemDao.findById(id);
      prefoamitem=foamitem;
      foamitemDao.update(prefoamitem);
    } catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("更新实体失败:"+e.getMessage());
    }
    return errorCode;
  }
}
