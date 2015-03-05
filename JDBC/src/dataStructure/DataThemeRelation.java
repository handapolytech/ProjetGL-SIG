package dataStructure;


public class DataThemeRelation extends Data{

	public static final String fieldId = "id";
	public static final String fieldIdSource = "id_source";
	public static final String fieldIdTheme = "id_theme";
	
	public int id;
	public int id_source;
	public int id_theme;
	
	public DataThemeRelation(){
		super();
		tableName = "theme_relation";
		defautUpdateColumns = new String[]{"id","id_source","id_theme"};		
	}

	public DataThemeRelation(int id, int id_source, int id_theme) {
		super();
		this.id = id;
		this.id_source = id_source;
		this.id_theme = id_theme;
	}
	
	
	
}
