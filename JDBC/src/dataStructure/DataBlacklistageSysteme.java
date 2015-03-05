package dataStructure;

import java.util.Date;

public class DataBlacklistageSysteme extends Data {

	public static final String fieldId = "id";
	public static final String fieldIdUtilisateur = "id_source";

	public int id;
	public int id_source;

	public DataBlacklistageSysteme() {
		super();
		tableName = "blacklistage_systeme";
		defautUpdateColumns = new String[] { "id","id_source"};
	}

	public DataBlacklistageSysteme(int id, int id_source) {
		this();
		this.id = id;
		this.id_source = id_source;
	}
	


}
