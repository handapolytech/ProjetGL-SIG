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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	
	
}
