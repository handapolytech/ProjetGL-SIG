package dataStructure;

public class DataTest extends Data{

	public int id;
	public int num;
	public String string;
	public String text;
		


	public DataTest(int id, int i, String string, String text) {
		super();
		this.tableName = "test";
		this.id = id;
		this.num = i;
		this.string = string;
		this.text = text;
	}
	
	public DataTest(int i, String string, String text){
		this(0,i,string,text);
	}

	@Override
	public String[] defautUpdateColums() {
		return new String[]{"id","num","string","text"};
	}

	

}
