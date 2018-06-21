package com.tonfun.tools.controller.autoController.BSOne;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;
import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.dao.persistence.pagination.Pagination;
import com.tonfun.tools.dao.persistence.pagination.Pagination.PaginationBuilder;
import com.tonfun.tools.Model.BSOne.Watersample;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IWatersampleService;

@Controller
@RequestMapping(value="/Watersample")
public class WatersampleController{
  private static final Logger LOGGER = LoggerFactory.getLogger(WatersampleController.class);
  @Autowired
  IWatersampleService watersampleservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showwatersamplePage() {
    return "/Watersample/watersample";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllWatersamples")
  @ResponseBody
  private List<Watersample> getAllWatersamples () {
    LOGGER.info("返回所有的数据");
    return watersampleservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllWatersamplesByPagination")
  @ResponseBody
  private Pagination<Watersample> getAllWatersamplesByPagination (PaginationBuilder<Watersample> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Watersample>  watersamples = watersampleservice.queryByPagination(paginationBuilder.build());
    return watersamples;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addWatersample")
  @ResponseBody
  private ErrorCode addWatersample(@Valid Watersample watersample,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.watersampleservice.save(watersample);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyWatersample (Long id,Watersample watersample,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);    }else {
      errorCode = this.watersampleservice.modifyWatersample(id,watersample);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteWatersample")
  @ResponseBody
  private ErrorCode deleteWatersample(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.watersampleservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
