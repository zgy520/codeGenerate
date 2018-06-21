package com.tonfun.tools.helper.DTO;
/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年6月13日 下午9:12:59
* 用于存放ID和text的实体类
*/
public class IDText {
	private Long id;
	private String text;
	public IDText() {
		
	}
	public IDText(Long id,String text) {
		this.id = id;
		this.text = text;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
