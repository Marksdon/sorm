package com.rand.sorm.bean;

/**
 * 封装列信息
 * @author randall
 *
 */
public class ColumnInfo {
	/**
	 * 字段名称
	 */
	private String name;
	/**
	 * 字段数据类型
	 */
	private String type;
	/**
	 * 键值类型(0普通类型，1主键，2外键)
	 */
	private int keyType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getKeyType() {
		return keyType;
	}
	public void setKeyType(int keyType) {
		this.keyType = keyType;
	}
	public ColumnInfo(String name, String type, int keyType) {
		super();
		this.name = name;
		this.type = type;
		this.keyType = keyType;
	}
	
	public ColumnInfo() {
	}
}
