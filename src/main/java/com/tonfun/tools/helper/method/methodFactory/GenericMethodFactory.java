package com.tonfun.tools.helper.method.methodFactory;
/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年6月16日 下午12:47:01
* 泛型工厂，用于一些基本数据属性的控制
*/

import java.io.PrintWriter;

import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.helper.Utils;
import com.tonfun.tools.helper.method.GenericMethodOuput;
import com.tonfun.tools.helper.method.MethodInfo;

public abstract class GenericMethodFactory {
	private GenericMethodOuput genericMethodOuput;
	protected final FileGeneratorType fileGeneratorType;
	private PrintWriter printWriter;
	private String tableName;
	private String captureTableName;
	
	public GenericMethodFactory(FileGeneratorType fileGeneratorType) {
		this.fileGeneratorType = fileGeneratorType;
	}
	/**
	 * 产生方法
	 */
	public void outputMethodContent() {
		this.genericMethodOuput.setMethodInfo(getMethodInfo());
		this.genericMethodOuput.outputMethod();
	}
	
	protected abstract MethodInfo getMethodInfo();  // 产生method信息
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
		this.captureTableName = Utils.captureName(tableName);
	}
	public String getCaptureTableName() {
		return captureTableName;
	}
	public PrintWriter getPrintWriter() {
		return printWriter;
	}
	public void setPrintWriter(PrintWriter printWriter) {
		this.printWriter = printWriter;
		this.genericMethodOuput = new GenericMethodOuput(this.printWriter);
	}
	
}
