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
import com.tonfun.tools.Model.sys.Org_type;
import com.tonfun.tools.service.I.module.sys.CI.sys.IOrg_typeService;

@Controller
@RequestMapping(value="/Org_type")
public class Org_typeController{
  private static final Logger LOGGER = LoggerFactory.getLogger(Org_typeController.class);
  @Autowired
  IOrg_typeService org_typeservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showorg_typePage() {
    return "/Org_type/org_type";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllOrg_types")
  @ResponseBody
  private List<Org_type> getAllOrg_types () {
    LOGGER.info("返回所有的数据");
    return org_typeservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllOrg_typesByPagination")
  @ResponseBody
  private Pagination<Org_type> getAllOrg_typesByPagination (PaginationBuilder<Org_type> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Org_type>  org_types = org_typeservice.queryByPagination(paginationBuilder.build());
    return org_types;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addOrg_type")
  @ResponseBody
  private ErrorCode addOrg_type(@Valid Org_type org_type,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.org_typeservice.save(org_type);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  @RequestMapping("/modifyorg_type")
  @ResponseBody
  public ErrorCode modifyOrg_type (Long id,Org_type org_type,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
    }else {
      errorCode = this.org_typeservice.modifyOrg_type(id,org_type);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteOrg_type")
  @ResponseBody
  private ErrorCode deleteOrg_type(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.org_typeservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
