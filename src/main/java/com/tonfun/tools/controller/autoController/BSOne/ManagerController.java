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
import com.tonfun.tools.Model.BSOne.Manager;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IManagerService;

@Controller
@RequestMapping(value="/Manager")
public class ManagerController{
  private static final Logger LOGGER = LoggerFactory.getLogger(ManagerController.class);
  @Autowired
  IManagerService managerservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showmanagerPage() {
    return "/Manager/manager";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllManagers")
  @ResponseBody
  private List<Manager> getAllManagers () {
    LOGGER.info("返回所有的数据");
    return managerservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllManagersByPagination")
  @ResponseBody
  private Pagination<Manager> getAllManagersByPagination (PaginationBuilder<Manager> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Manager>  managers = managerservice.queryByPagination(paginationBuilder.build());
    return managers;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addManager")
  @ResponseBody
  private ErrorCode addManager(@Valid Manager manager,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.managerservice.save(manager);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyManager (Long id,Manager manager,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);    }else {
      errorCode = this.managerservice.modifyManager(id,manager);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteManager")
  @ResponseBody
  private ErrorCode deleteManager(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.managerservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
