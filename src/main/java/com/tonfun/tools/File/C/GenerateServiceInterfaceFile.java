package com.tonfun.tools.File.C;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.tonfun.tools.Error.DefaultErrorCode;
import com.tonfun.tools.Error.ErrCode;
import com.tonfun.tools.Error.ErrorCode;
import com.tonfun.tools.File.FileGeneratorType;
import com.tonfun.tools.File.I.FileGeneratorInterface;
import com.tonfun.tools.dao.util.Table;
import com.tonfun.tools.helper.FileOperator;
import com.tonfun.tools.helper.Utils;
import com.tonfun.tools.helper.xml.XmlParserFactory;

/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年5月20日 下午2:51:45
*/
public class GenerateServiceInterfaceFile implements FileGeneratorInterface {

	/** ========================================================================================
	 * generateCodeFile: 
	 * @param table
	 * @param file
	 * @return
	 * @see com.tonfun.tools.File.I.FileGeneratorInterface#generateCodeFile(com.tonfun.tools.dao.util.Table, com.tonfun.tools.helper.FileOperator)
	 * =======================================================================================*/
	@Override
	public ErrorCode generateCodeFile(Table table, FileOperator fileOperator) {
		// TODO Auto-generated method stub
		ErrorCode errorCode = new DefaultErrorCode();
		String modelName = com.tonfun.tools.helper.Utils.captureName(table.getTableName());
		File file = new File(fileOperator.getPackageDir(),"I"+modelName+"Service.java");
		
		try {
			if (!file.exists()) {				
				file.createNewFile();				
			}
			
			FileWriter fileWriter = new FileWriter(file);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.println("package "+fileOperator.getPackage_Name()+";");  // 产生包名
			
			outputPackage(printWriter,modelName);  //将相关的包输出
			
			// 以下两行用于在类的头部添加实体类的标识			
			printWriter.println("public interface I"+Utils.captureName(table.getTableName())+"Service" +
			" extends IGenericSysService<"+modelName+", Long> " +
			"{\r\n");  //产生类名
			
			printWriter.println("}");  // 产生结尾符号
			printWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorCode.setErrCode(ErrCode.FAIL);
			errorCode.setErrMsg("写入文件失败:"+e.getMessage());
		}
		
		return errorCode;
	}
	/**
	 * ========================================================================================
	 * outputPackage: 输出包名
	 * @param printWriter
	 * @param modelName
	 * =======================================================================================
	 */
	public void outputPackage(PrintWriter printWriter,String modelName) {
		printWriter.println("\r\nimport com.tonfun.tools.service.I.module.sys.IGenericSysService;"
				+ "\r\nimport "+XmlParserFactory.getXmlParser().xmlParser(FileGeneratorType.Model,"packageName")+"."+modelName+";\r\n");
	}

}
