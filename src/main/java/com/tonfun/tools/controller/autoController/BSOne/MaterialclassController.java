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
import com.tonfun.tools.Model.BSOne.Materialclass;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IMaterialclassService;

@Controller
@RequestMapping(value="/Materialclass")
public class MaterialclassController{
  private static final Logger LOGGER = LoggerFactory.getLogger(MaterialclassController.class);
  @Autowired
  IMaterialclassService materialclassservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showmaterialclassPage() {
    return "/Materialclass/materialclass";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllMaterialclasss")
  @ResponseBody
  private List<Materialclass> getAllMaterialclasss () {
    LOGGER.info("返回所有的数据");
    return materialclassservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllMaterialclasssByPagination")
  @ResponseBody
  private Pagination<Materialclass> getAllMaterialclasssByPagination (PaginationBuilder<Materialclass> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Materialclass>  materialclasss = materialclassservice.queryByPagination(paginationBuilder.build());
    return materialclasss;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addMaterialclass")
  @ResponseBody
  private ErrorCode addMaterialclass(@Valid Materialclass materialclass,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.materialclassservice.save(materialclass);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyMaterialclass (Long id,Materialclass materialclass,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);    }else {
      errorCode = this.materialclassservice.modifyMaterialclass(id,materialclass);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteMaterialclass")
  @ResponseBody
  private ErrorCode deleteMaterialclass(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.materialclassservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
