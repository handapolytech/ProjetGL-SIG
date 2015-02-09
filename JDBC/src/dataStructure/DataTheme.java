package dataStructure;

public class DataTheme extends Data{

	public int id;
	public String theme;
		
	public DataTheme(int id, String theme) {
		super();
		this.tableName = "theme";
		this.id = id;
		this.theme = theme;
	}
	//Ce constructeur prend 0 comme id pour l'opération de l'insertion
	public DataTheme(String theme) {
		this(0,theme);
	}

	@Override
	public String[] defautUpdateColums() {
		return new String[]{"id","theme"};
	}
	
}
