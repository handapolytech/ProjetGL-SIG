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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_source() {
		return id_source;
	}

	public void setId_source(int id_source) {
		this.id_source = id_source;
	}

	public int getId_theme() {
		return id_theme;
	}

	public void setId_theme(int id_theme) {
		this.id_theme = id_theme;
	}

	@Override
	public String toString() {
		return "ThemeRelation [id=" + id + ", id_source=" + id_source
				+ ", id_theme=" + id_theme + "]";
	}
	
	
	
}
