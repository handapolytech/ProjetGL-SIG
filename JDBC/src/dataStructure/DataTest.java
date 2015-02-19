package dataStructure;

import java.sql.ResultSet;
import java.util.Date;

public class DataTest extends Data {

	public static final String fieldId = "id";
	public static final String fieldNum = "num";
	public static final String fieldString = "string";
	public static final String fieldText = "text";
	public static final String fieldDate = "date";

	public int id;
	public int num;
	public String string;
	public String text;
	public Date date;

	public DataTest() {
		super();
		tableName = "test";
		defautUpdateColumns = new String[] { "id", "num",
				"string", "text", "date" };
	}

	public DataTest(int id, int i, String string, String text, Date date) {
		this();
		this.id = id;
		this.num = i;
		this.string = string;
		this.text = text;
		this.date = date;
	}


}
