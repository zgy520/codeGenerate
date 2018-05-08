/*
** TONFUN CONFIDENTIAL AND PROPRIETARY.
**
** This source is the sole property of Tonfun CO.,Ltd. Reproduction or Utilization of this source
** in whole or in part is forbidden without the written consent of Tonfun CO.,Ltd.
** 此文件所有权仅归天津同丰信息技术有限公司所有。
** 未经天津同丰信息技术有限公司书面同意，严禁对此文件的全部或部分进行复制或使用。
**
** Tonfun CONFIDENTIAL.
** Copyright 2011-2018 Tonfun Corporation All Rights Reserved.
** 天津同丰信息技术有限公司机密。
** Copyright 2011-2018 天津同丰信息技术有限公司保留所有权利。
**--------------------------------------------------------------------------------------------------
**
**  文件名: FileOperator.java
**  描  述: 
**  作  者: a4423
**  时  间: 2018年4月26日 下午2:17:10
**------------------------------------------------------------------------------------------------*/
package com.tonfun.tools.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.regex.Pattern;

/** ========================================================================================
 * @author a4423
 * 
 * =======================================================================================*/
public class FileOperator {
	private final static String srcPath = "src\\main\\java";  // 设置中间目录，默认为此，即java目录结构的实际情况
	private Optional<String> outputDir;   //文件的产出目录
	private Optional<String> packageName;  //包名
	private final OutputStyle outputStyle;
	private String package_Name;
	/**
	 * ========================================================================================
	 * 默认构造函数
	 * =======================================================================================
	 */
	public FileOperator() {
		this.outputStyle = OutputStyle.Default;  //首先默认情况		
	}
	/**
	 * ========================================================================================
	 * 构造函数 带有中间路径的构造函数,参数为路径的形式，如"src\\main\\java"
	 * @param srcPath
	 * =======================================================================================
	 */
	public FileOperator(OutputStyle outputStyle) {			
		this.outputStyle = outputStyle;			
	}
	/**
	 * ========================================================================================
	 * getOutputDir: 获取最终的输出目录 
	 * @return
	 * =======================================================================================
	 */
	public String getFinalOutputDir() {
		String finalOutputDir = "";
		if (this.outputStyle == OutputStyle.Default) {
			finalOutputDir = getDefaultOutputDir();
		}else if (this.outputStyle == OutputStyle.Custom) {
			finalOutputDir = getOutputDir();
		}
		return finalOutputDir;
	}
	/**
	 * ========================================================================================
	 * getDefaultOutputDir:获取默认的输出目录 
	 * @return
	 * =======================================================================================
	 */
	private String getDefaultOutputDir() {
		StringBuilder defaultOutputDir = new StringBuilder();
		defaultOutputDir.append(this.getAbsolutePath());  //追加绝对路径
		defaultOutputDir.append("\\");
		defaultOutputDir.append(srcPath);
		return defaultOutputDir.toString();
	}
	/**
	 * ========================================================================================
	 * getPackageDir: 根据输出路径和包名获取最终的输出目录
	 * @return
	 * =======================================================================================
	 */
	public String getPackageDir() {
		String outputFinalDir = this.getFinalOutputDir()+"\\"+this.getPackageName();
		File outputDir = new File(outputFinalDir);  
		if (!outputDir.exists()) {  //判断路径是否存在，不存在则创建
			outputDir.mkdirs();
		}
		return outputFinalDir;
	}
	
	/**
	 * ========================================================================================
	 * getAbsolutePath: 获取当前项目的绝对路径 
	 * @return
	 * =======================================================================================
	 */
	private String getAbsolutePath() {
		Path currentRelativePath = Paths.get("");
		String absolutePath = currentRelativePath.toAbsolutePath().toString();
		return absolutePath;
	}
	/** ========================================================================================
	 * getOutputDir: 获取设置的输出目录
	 * @return outputDir
	 * =======================================================================================*/
	public String getOutputDir() {		
		String fnalDir = "";
		if (outputDir==null || outputDir.get().equals("")) {			
			try {
				throw new Exception("请首先设置自定义的输出目录，或者使用默认的输出路径");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fnalDir = "目录未设置";
			}		
		}else {
			if (!Files.exists(Paths.get(outputDir.get()), LinkOption.NOFOLLOW_LINKS)) {
				try {
					throw new Exception("设置的目录不存在，请提前创建");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					fnalDir ="设置的目录不存在，请提前创建";
				}				
			}else {
				fnalDir = outputDir.get();
			}
		}
		return fnalDir;
	}
	/** ========================================================================================
	 * setOutputDir: 设置输出目录
	 * @param outputDir 要设置的 outputDir
	 * =======================================================================================*/
	public void setOutputDir(String outputDir) {
		this.outputDir = Optional.of(outputDir);
	}
	/** ========================================================================================
	 * getPackageName: 获取所设置的包名
	 * @return packageName
	 * =======================================================================================*/
	public String getPackageName() {
		return packageName.get();
	}
	/** ========================================================================================
	 * setPackageName: 设置包名
	 * @param packageName 要设置的 packageName
	 * =======================================================================================*/
	public void setPackageName(Optional<String> packageName) {		
		this.package_Name = packageName.get();
		String packageNamedd = packageName.get();
		String replacedStr = packageNamedd.replaceAll(Pattern.quote("."), "\\\\");
		this.packageName = Optional.of(replacedStr);
	}
	/** ========================================================================================
	 * getPackage_Name: 
	 * @return package_Name
	 * =======================================================================================*/
	public String getPackage_Name() {
		return package_Name;
	}
	
	
}
