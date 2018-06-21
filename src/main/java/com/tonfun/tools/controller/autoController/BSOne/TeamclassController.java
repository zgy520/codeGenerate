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
import com.tonfun.tools.Model.BSOne.Teamclass;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.ITeamclassService;

@Controller
@RequestMapping(value="/Teamclass")
public class TeamclassController{
  private static final Logger LOGGER = LoggerFactory.getLogger(TeamclassController.class);
  @Autowired
  ITeamclassService teamclassservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showteamclassPage() {
    return "/Teamclass/teamclass";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllTeamclasss")
  @ResponseBody
  private List<Teamclass> getAllTeamclasss () {
    LOGGER.info("返回所有的数据");
    return teamclassservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllTeamclasssByPagination")
  @ResponseBody
  private Pagination<Teamclass> getAllTeamclasssByPagination (PaginationBuilder<Teamclass> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Teamclass>  teamclasss = teamclassservice.queryByPagination(paginationBuilder.build());
    return teamclasss;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addTeamclass")
  @ResponseBody
  private ErrorCode addTeamclass(@Valid Teamclass teamclass,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.teamclassservice.save(teamclass);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyTeamclass (Long id,Teamclass teamclass,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);    }else {
      errorCode = this.teamclassservice.modifyTeamclass(id,teamclass);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteTeamclass")
  @ResponseBody
  private ErrorCode deleteTeamclass(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.teamclassservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
