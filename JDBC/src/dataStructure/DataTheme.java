package dataStructure;

public class DataTheme extends Data{

	public static final String fieldId = "id";
	public static final String fieldTheme = "theme";
	
	public int id;
	public String theme;
	
	public DataTheme(){
		super();
		tableName = "theme";
		defautUpdateColumns = new String[]{"id","theme"};		
	}
	
	public DataTheme(int id, String theme) {
		this();
		this.id = id;
		this.theme = theme;
	}
	
}
