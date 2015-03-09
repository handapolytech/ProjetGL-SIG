package com.ppsinfo.rsig.jdbc.model;

public class BlacklistageSysteme extends BasicData {

	public static final String fieldId = "id";
	public static final String fieldIdUtilisateur = "id_source";

	public int id;
	public int id_source;

	public BlacklistageSysteme() {
		super();
		tableName = "blacklistage_systeme";
		defautUpdateColumns = new String[] { "id","id_source"};
	}

	public BlacklistageSysteme(int id, int id_source) {
		this();
		this.id = id;
		this.id_source = id_source;
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

	@Override
	public String toString() {
		return "BlacklistageSysteme [id=" + id + ", id_source=" + id_source
				+ "]";
	}
	


}
