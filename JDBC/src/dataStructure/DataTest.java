package dataStructure;

import java.sql.ResultSet;

public class DataTest extends Data{

	public static final String fieldId = "id";
	public static final String fieldNum = "num";
	public static final String fieldString = "string";
	public static final String fieldText = "text";
	
	public int id;
	public int num;
	public String string;
	public String text;
	
	public static String tableName = "test";		
	public static String[] defautUpdateColums = new String[]{"id","num","string","text"};
	
	public DataTest(){
		super();
	}
	
	public DataTest(int id, int i, String string, String text) {
		this();
		this.id = id;
		this.num = i;
		this.string = string;
		this.text = text;
	}
	
	public DataTest(int i, String string, String text){
		this(0,i,string,text);
	}

	

	

}
