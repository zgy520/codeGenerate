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
import com.tonfun.tools.Model.sys.Role;
import com.tonfun.tools.service.I.module.sys.CI.sys.IRoleService;

@Controller
@RequestMapping(value="/Role")
public class RoleController{
  private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);
  @Autowired
  IRoleService roleservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showrolePage() {
    return "/Role/role";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllRoles")
  @ResponseBody
  private List<Role> getAllRoles () {
    LOGGER.info("返回所有的数据");
    return roleservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllRolesByPagination")
  @ResponseBody
  private Pagination<Role> getAllRolesByPagination (PaginationBuilder<Role> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Role>  roles = roleservice.queryByPagination(paginationBuilder.build());
    return roles;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addRole")
  @ResponseBody
  private ErrorCode addRole(@Valid Role role,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.roleservice.save(role);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  @RequestMapping("/modifyrole")
  @ResponseBody
  public ErrorCode modifyRole (Long id,Role role,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
    }else {
      errorCode = this.roleservice.modifyRole(id,role);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteRole")
  @ResponseBody
  private ErrorCode deleteRole(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.roleservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
