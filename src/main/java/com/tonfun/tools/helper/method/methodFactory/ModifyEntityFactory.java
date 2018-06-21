package com.tonfun.tools.helper.method.methodFactory;

import java.security.InvalidParameterException;

import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.helper.method.MethodInfo;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年6月16日 下午1:04:21
*/
public class ModifyEntityFactory extends GenericMethodFactory {

	
	public ModifyEntityFactory(FileGeneratorType fileGeneratorType) {
		super(fileGeneratorType);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected MethodInfo getMethodInfo() {
		// TODO Auto-generated method stub
		MethodInfo methodInfo = new MethodInfo("public ", "ErrorCode ", "modify"+this.getCaptureTableName()+" ", false);
		String[] argTypes = {"Long",this.getCaptureTableName()};
		String[] argValues = {"id",this.getTableName()};
		methodInfo.setArgsTypesList(argTypes);
		methodInfo.setArgsList(argValues);
		methodInfo.setMethodComment("修改实体的属性值");
		if(fileGeneratorType == FileGeneratorType.Controller) {
			methodInfo = getControllerMethod(methodInfo);
		}else if (fileGeneratorType == FileGeneratorType.ServiceImpl) {
			methodInfo = getServiceImplMethod(methodInfo);
		}else if (fileGeneratorType == FileGeneratorType.ServiceInterface) {
			methodInfo = getServiceInterfaceMethod(methodInfo);
		}else {
			throw new InvalidParameterException("不合法的参数异常");
		}
		return methodInfo;
	}
	/**
	 * 产生controller中修改实体的方法
	 * @param methodInfo
	 * @return
	 * LOGGER.info("编辑id为"+id+"的实体数据");
	  ErrorCode errorCode = new DefaultErrorCode();
	  if (bindingResult.hasErrors()) {
		errorCode.setErrMsg("验证失败:"+bindingResult.getAllErrors());
		errorCode.setErrCode(ErrCode.VALIDATION_FAILED);
		}else {
			errorCode = this.customerservice.modifyCustomer(id, customer);
		}
	  return errorCode;
	 */
	private MethodInfo getControllerMethod(MethodInfo methodInfo) {
		String[] annotations = {"@RequestMapping(\"/modify"+this.getTableName()+"\")","@ResponseBody"};
		methodInfo.setMethodAnnotations(annotations);
		String[] argsList = new String[methodInfo.getArgsList().length + 1];
		String[] argsType = new String[methodInfo.getArgsTypesList().length + 1];
		System.arraycopy(methodInfo.getArgsList(), 0, argsList, 0, methodInfo.getArgsList().length);
		System.arraycopy(methodInfo.getArgsTypesList(), 0, argsType, 0, methodInfo.getArgsTypesList().length);
		argsList[2] = "bindingResult";
		argsType[2] = "@Valid BindingResult";
		methodInfo.setArgsList(argsList);
		methodInfo.setArgsTypesList(argsType);
		methodInfo.setMethodContent(new StringBuilder().append("    LOGGER.info(\"编辑id为\"+id+\"的实体属性\");\r\n")
									.append("    ErrorCode errorCode = new DefaultErrorCode();\r\n")
									.append("    if (bindingResult.hasErrors()) {\r\n")
									.append("      errorCode.setErrMsg(\"验证失败:\"+bindingResult.getAllErrors());\r\n")
									.append("      errorCode.setErrCode(ErrCode.VALIDATION_FAILED);\r\n")
									.append("    }else {\r\n")
									.append("      errorCode = this."+this.getTableName()+"service."+methodInfo.getMethodName().trim()+"(id,"+this.getTableName()+");\r\n")
									.append("    }\r\n")
									.append("    return errorCode;"));
		return methodInfo;
	}
	/**
	 * 产生service实现类中的修改实体的方法
	 * @param methodInfo
	 * @return
	 * 
	 * @Override
		public ErrorCode modifyCustomer(Long id, Customer customer) {
			// TODO Auto-generated method stub
			ErrorCode errorCode = new DefaultErrorCode();
			try {
				Customer preCustomer = customerDao.findById(id);
				preCustomer = customer;
				customerDao.update(preCustomer);
			} catch (Exception e) {
				// TODO: handle exception
				errorCode.setErrCode(ErrCode.FAIL);
				errorCode.setErrMsg("更新实体失败:"+e.getMessage());
			}
			return errorCode;
		}
	 */
	private MethodInfo getServiceImplMethod(MethodInfo methodInfo) {
		methodInfo.setOverrided(true);
		methodInfo.setMethodContent(new StringBuilder()
				   .append("    ErrorCode errorCode = new DefaultErrorCode();\r\n")
				   .append("    try {\r\n")
				   .append("      "+this.getCaptureTableName()+" pre"+this.getTableName() +"="+ this.getTableName()+"Dao.findById(id);\r\n")
				   .append("      pre"+this.getTableName() + "=" + this.getTableName()+";\r\n")
				   .append("      "+this.getTableName()+"Dao.update(pre"+this.getTableName()+");\r\n")
				   .append("    } catch (Exception e) {\r\n")
				   .append("      errorCode.setErrCode(ErrCode.FAIL);\r\n")
				   .append("      errorCode.setErrMsg(\"更新实体失败:\"+e.getMessage());\r\n")
				   .append("    }\r\n")
				   .append("    return errorCode;"));
		return methodInfo;
	}
	/**
	 * 产生service接口中修改实体类的方法
	 * @param methodInfo
	 * @return
	 * public ErrorCode modifyCustomer(Long id,Customer customer);  // 修改指定Id的对象
	 */
	private MethodInfo getServiceInterfaceMethod(MethodInfo methodInfo) {
		methodInfo.setSpecifiedMethod(true);
		return methodInfo;
	}

}
