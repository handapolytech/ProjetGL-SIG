package com.ppsinfo.rsig.jdbc.model;

public class Theme extends BasicData{

	public static final String fieldId = "id";
	public static final String fieldTheme = "theme";
	
	public int id;
	public String theme;
	
	public Theme(){
		super();
		tableName = "theme";
		defautUpdateColumns = new String[]{"id","theme"};		
	}
	
	public Theme(int id, String theme) {
		this();
		this.id = id;
		this.theme = theme;
	}
	
}
