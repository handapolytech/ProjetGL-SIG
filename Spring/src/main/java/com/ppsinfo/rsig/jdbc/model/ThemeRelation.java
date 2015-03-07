package com.ppsinfo.rsig.jdbc.model;


public class ThemeRelation extends BasicData{

	public static final String fieldId = "id";
	public static final String fieldIdSource = "id_source";
	public static final String fieldIdTheme = "id_theme";
	
	public int id;
	public int id_source;
	public int id_theme;
	
	public ThemeRelation(){
		super();
		tableName = "theme_relation";
		defautUpdateColumns = new String[]{"id","id_source","id_theme"};		
	}

	public ThemeRelation(int id, int id_source, int id_theme) {
		this();
		this.id = id;
		this.id_source = id_source;
		this.id_theme = id_theme;
	}
	
	
	
}
