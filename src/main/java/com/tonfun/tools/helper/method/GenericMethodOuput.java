package com.tonfun.tools.helper.method;

import java.io.PrintWriter;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年5月31日 下午11:12:00
*/
public class GenericMethodOuput {
	private MethodInfo methodInfo;
	private final PrintWriter printWriter;
	public GenericMethodOuput(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}
	/**
	 * 产生相应的方法
	 */
	public final void outputMethod() {
		this.outputMethodComment();
		this.outputMethodOverride();
		this.outputMethodAnnotation();
		this.outputMethodTitle();
		this.ouputMethodContent();
		if (!this.methodInfo.isSpecifiedMethod()) {
			this.outputMethodEnd();
		}		
	}
	/**
	 * 输出方法注释
	 */
	private void outputMethodComment() {
		this.printWriter.println("  /**");
		this.printWriter.print("  * ");
		if (this.methodInfo.getMethodComment()!=null && !this.methodInfo.getMethodComment().equals("")) {
			this.printWriter.print("  "+this.methodInfo.getMethodComment());
		}
		this.printWriter.println("\r\n  */");
	}
	/**
	 * 输出重载标识
	 */
	private void outputMethodOverride() {
		if (this.methodInfo.isOverrided()) {
			this.printWriter.println("  "+"@Override");
		}
	}
	/**
	 * 方法标注
	 */
	private void outputMethodAnnotation() {
		if (this.methodInfo.getMethodAnnotations() != null && this.methodInfo.getMethodAnnotations().length > 0) {
			int len = this.methodInfo.getMethodAnnotations().length;
			for(int i = 0; i < len; i++) {
				this.printWriter.println("  "+this.methodInfo.getMethodAnnotations()[i]);
			}
		}
	}
	/**
	 * 输出方法表头
	 */
	private void outputMethodTitle() {
		this.ouputMethodAccessible();
		this.outputMethodReturnType();
		this.ouputMethodName();
		this.outputMethodParams();
	}
	/**
	 * 输出方法级别
	 */
	private void ouputMethodAccessible() {
		this.printWriter.print("  "+this.methodInfo.getMethodAccessible());
	}
	/**
	 * 输出方法返回类型
	 */
	private void outputMethodReturnType() {
		this.printWriter.print(this.methodInfo.getMethodReturnType());
	}
	/**
	 * 输出方法内容
	 */
	private void ouputMethodName() {
		this.printWriter.print(this.methodInfo.getMethodName());
	}
	/**
	 * 输出方法头部的其他信息
	 */
	private void outputMethodParams() {
		this.printWriter.print("(");
		if (this.methodInfo.getArgsTypesList()!=null) {
			int countOfParms = this.methodInfo.getArgsTypesList().length;
			if (countOfParms > 0) {
				for(int i = 0; i < countOfParms; i++) {
					this.printWriter.print(this.methodInfo.getArgsTypesList()[i]);
					this.printWriter.print(" ");
					this.printWriter.print(this.methodInfo.getArgsList()[i]);
					if (i < countOfParms - 1) {
						this.printWriter.print(",");
					}				
				}
			}
		}
		if (!methodInfo.isSpecifiedMethod()) {
			this.printWriter.println(") {");
		}else {
			this.printWriter.println(");");
		}
	}
	/**
	 * 输出方法内容
	 */
	private void ouputMethodContent() {
		if (this.methodInfo.getMethodContent()!=null) {
			this.printWriter.println(this.methodInfo.getMethodContent().toString());
		}
	}
	/**
	 * 输出方法结束符
	 */
	private void outputMethodEnd() {
		this.printWriter.println("  }");
	}
	public void setMethodInfo(MethodInfo methodInfo) {
		this.methodInfo = methodInfo;
	}
}
