package com.rand.sorm.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 封装表信息
 * @author randall
 *
 */
public class TableInfo {
	/**
	 * 表名称
	 */
	private String tname;
	/**
	 * 表的所有字段
	 */ 
	private Map<String, ColumnInfo> columns;
	/**
	 * 主键，目前只支持唯一主键
	 */
	private ColumnInfo onlyPriKey;
	/**
	 * 联合主键
	 */
	private List<ColumnInfo> priKeys;
	
	
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Map<String, ColumnInfo> getColumns() {
		return columns;
	}
	public void setColumns(Map<String, ColumnInfo> columns) {
		this.columns = columns;
	}
	public ColumnInfo getOnlyPriKey() {
		return onlyPriKey;
	}
	public void setOnlyPriKey(ColumnInfo onlyPriKey) {
		this.onlyPriKey = onlyPriKey;
	}
	public List<ColumnInfo> getPriKeys() {
		return priKeys;
	}
	public void setPriKeys(List<ColumnInfo> priKeys) {
		this.priKeys = priKeys;
	}
	
	public TableInfo(String tname, Map<String, ColumnInfo> columns, ColumnInfo onlyPriKey, List<ColumnInfo> priKeys) {
		super();
		this.tname = tname;
		this.columns = columns;
		this.onlyPriKey = onlyPriKey;
		this.priKeys = priKeys;
	}
	
	public TableInfo() {
		columns = new HashMap<String, ColumnInfo>();
		priKeys = new ArrayList<ColumnInfo>();
	}
	
}
