package com.tonfun.tools.controller.autoController.sys;
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
import com.tonfun.tools.Model.sys.System_param;
import com.tonfun.tools.service.I.module.sys.CI.sys.ISystem_paramService;

@Controller
@RequestMapping(value="/System_param")
public class System_paramController{
  private static final Logger LOGGER = LoggerFactory.getLogger(System_paramController.class);
  @Autowired
  ISystem_paramService system_paramservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showsystem_paramPage() {
    return "/System_param/system_param";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllSystem_params")
  @ResponseBody
  private List<System_param> getAllSystem_params () {
    LOGGER.info("返回所有的数据");
    return system_paramservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllSystem_paramsByPagination")
  @ResponseBody
  private Pagination<System_param> getAllSystem_paramsByPagination (PaginationBuilder<System_param> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<System_param>  system_params = system_paramservice.queryByPagination(paginationBuilder.build());
    return system_params;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addSystem_param")
  @ResponseBody
  private ErrorCode addSystem_param(@Valid System_param system_param,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.system_paramservice.save(system_param);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  @RequestMapping("/modifysystem_param")
  @ResponseBody
  public ErrorCode modifySystem_param (Long id,System_param system_param,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
    }else {
      errorCode = this.system_paramservice.modifySystem_param(id,system_param);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteSystem_param")
  @ResponseBody
  private ErrorCode deleteSystem_param(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.system_paramservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
