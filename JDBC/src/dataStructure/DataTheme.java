package dataStructure;

import java.sql.ResultSet;

public class DataTheme extends Data{

	public static final String fieldId = "id";
	public static final String fieldTheme = "theme";
	
	public int id;
	public String theme;
	
	protected DataTheme(){
		super();
		tableName = "theme";
		DataTheme.defautUpdateColums = new String[]{"id","theme"};		
	}
	
	public DataTheme(ResultSet resultSet){
		super();
	}
	
	public DataTheme(int id, String theme) {
		this();
		this.id = id;
		this.theme = theme;
	}
	//Ce constructeur prend 0 comme id pour l'opération de l'insertion
	public DataTheme(String theme) {
		this(0,theme);
	}
	
}
