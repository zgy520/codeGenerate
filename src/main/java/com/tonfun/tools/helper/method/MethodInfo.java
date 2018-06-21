package com.tonfun.tools.helper.method;
/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年5月31日 下午10:47:59
* 方法模型
*/
public class MethodInfo {
	private final String methodName;  // 方法名称
	private final String methodReturnType;  // 方法的返回类型
	private final String methodAccessible;  // 方法级别  private protected public
	private String methodComment;  // 方法注释
	private StringBuilder methodContent; // 方法内容
	private boolean isOverrided;  // 是否是重载方法
	private String[] methodAnnotations; // 方法注解
	private String[] argsTypesList;  // 参数类型列表
	private String[] argsList;  // 参数列表
	private Boolean isSpecifiedMethod;  //是否特殊方法，即接口方法或者抽象方法
	
	public MethodInfo(String methodAccessible,String methodReturnType,
			String methodName,boolean isOverrided) {
		this.methodAccessible = methodAccessible;
		this.methodReturnType = methodReturnType;
		this.methodName = methodName;
		this.isOverrided = isOverrided;
	}

	public String getMethodComment() {
		return methodComment;
	}

	public void setMethodComment(String methodComment) {
		this.methodComment = methodComment;
	}

	public StringBuilder getMethodContent() {
		return methodContent;
	}

	public void setMethodContent(StringBuilder methodContent) {
		this.methodContent = methodContent;
	}

	public String getMethodName() {
		return methodName;
	}

	public String getMethodReturnType() {
		return methodReturnType;
	}

	public String getMethodAccessible() {
		return methodAccessible;
	}

	public boolean isOverrided() {
		return isOverrided;
	}

	public String[] getArgsTypesList() {
		return argsTypesList;
	}

	public String[] getArgsList() {
		return argsList;
	}

	public void setArgsTypesList(String[] argsTypesList) {
		this.argsTypesList = argsTypesList;
	}

	public void setArgsList(String[] argsList) {
		this.argsList = argsList;
	}

	public String[] getMethodAnnotations() {
		return methodAnnotations;
	}

	public void setMethodAnnotations(String[] methodAnnotations) {
		this.methodAnnotations = methodAnnotations;
	}

	public boolean isSpecifiedMethod() {
		if (isSpecifiedMethod==null) {
			this.isSpecifiedMethod = false;
		}
		return isSpecifiedMethod;
	}

	public void setSpecifiedMethod(boolean isSpecifiedMethod) {
		this.isSpecifiedMethod = isSpecifiedMethod;
	}

	public void setOverrided(boolean isOverrided) {
		this.isOverrided = isOverrided;
	}
	
}
