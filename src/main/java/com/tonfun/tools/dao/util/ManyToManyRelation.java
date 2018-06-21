package com.tonfun.tools.dao.util;
/**
* @author 张广义 E-mail:a442391947@outlook.com
* @version 创建时间：2018年6月21日 下午8:29:04
* 记录数据库中多对多的相关信息，用于处理多对多的关系
*/
public class ManyToManyRelation {
	private String curTableName;
	private String relationName;
	private String primaryTableName;
	private String primaryColumnName;
	private String miniorTableName;
	private String miniorColumnName;
	private boolean isHandled;  // 是否已经处理过
	
	public ManyToManyRelation(String curTableName,String primaryTable,String primaryColumnName,String miniorTableName,String miniorColumnName) {
		this.curTableName = curTableName;
		this.primaryTableName = primaryTable;
		this.miniorTableName = miniorTableName;
		this.setPrimaryColumnName(primaryColumnName);
		this.setMiniorColumnName(miniorColumnName);
		this.isHandled = false;
	}
	
	public String getRelationName() {
		return relationName;
	}
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	public String getPrimaryTableName() {
		return primaryTableName;
	}
	public void setPrimaryTableName(String primaryTableName) {
		this.primaryTableName = primaryTableName;
	}
	public String getMiniorTableName() {
		return miniorTableName;
	}
	public void setMiniorTableName(String miniorTableName) {
		this.miniorTableName = miniorTableName;
	}
	public boolean isHandled() {
		return isHandled;
	}
	public void setHandled(boolean isHandled) {
		this.isHandled = isHandled;
	}

	public String getCurTableName() {
		return curTableName;
	}

	public void setCurTableName(String curTableName) {
		this.curTableName = curTableName;
	}

	public String getMiniorColumnName() {
		return miniorColumnName;
	}

	public void setMiniorColumnName(String miniorColumnName) {
		this.miniorColumnName = miniorColumnName;
	}

	public String getPrimaryColumnName() {
		return primaryColumnName;
	}

	public void setPrimaryColumnName(String primaryColumnName) {
		this.primaryColumnName = primaryColumnName;
	}
}
