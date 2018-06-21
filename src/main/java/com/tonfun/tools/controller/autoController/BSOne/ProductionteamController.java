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
import com.tonfun.tools.Model.BSOne.Productionteam;
import com.tonfun.tools.service.I.module.BSOne.CI.BSOne.IProductionteamService;

@Controller
@RequestMapping(value="/Productionteam")
public class ProductionteamController{
  private static final Logger LOGGER = LoggerFactory.getLogger(ProductionteamController.class);
  @Autowired
  IProductionteamService productionteamservice;

  /**
  *   返回对应的jsp页面的路径
  */
  @RequestMapping("/")
  private String showproductionteamPage() {
    return "/Productionteam/productionteam";
  }
  /**
  *   返回所有的数据
  */
  @RequestMapping("/getAllProductionteams")
  @ResponseBody
  private List<Productionteam> getAllProductionteams () {
    LOGGER.info("返回所有的数据");
    return productionteamservice.findAll();
  }
  /**
  *   根据分页信息获取数据
  */
  @RequestMapping("/getAllProductionteamsByPagination")
  @ResponseBody
  private Pagination<Productionteam> getAllProductionteamsByPagination (PaginationBuilder<Productionteam> paginationBuilder) {
    LOGGER.info("根据分页信息返回相应的数据");
    Pagination<Productionteam>  productionteams = productionteamservice.queryByPagination(paginationBuilder.build());
    return productionteams;
  }
  /**
  *   新增数据
  */
  @RequestMapping("/addProductionteam")
  @ResponseBody
  private ErrorCode addProductionteam(@Valid Productionteam productionteam,BindingResult bindingResult) {
    LOGGER.info("新增数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
      errorCode.setErrMsg("验证失败"+bindingResult.getAllErrors());
    }else {
      this.productionteamservice.save(productionteam);
    }
    return errorCode;
  }
  /**
  *   修改实体的属性值
  */
  public ErrorCode modifyProductionteam (Long id,Productionteam productionteam,@Valid BindingResult bindingResult) {
    LOGGER.info("编辑id为"+id+"的实体属性");
    ErrorCode errorCode = new DefaultErrorCode();
    if (bindingResult.hasErrors()) {
      errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);    }else {
      errorCode = this.productionteamservice.modifyProductionteam(id,productionteam);
    }
    return errorCode;
  }
  /**
  *   根据Id删除实体
  */
  @RequestMapping("/deleteProductionteam")
  @ResponseBody
  private ErrorCode deleteProductionteam(Long id) {
    LOGGER.info("删除id为"+id+"对应的实体数据");
    DefaultErrorCode errorCode = new DefaultErrorCode();
    try {
      this.productionteamservice.deleteById(id);
    }catch (Exception e) {
      errorCode.setErrCode(ErrCode.FAIL);
      errorCode.setErrMsg("删除失败，错误提示为:"+e.getMessage());
    }
    return errorCode;
  }
}
