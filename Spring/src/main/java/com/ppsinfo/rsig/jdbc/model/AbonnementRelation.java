package com.ppsinfo.rsig.jdbc.model;

public class AbonnementRelation extends BasicData {

	public static final String fieldId = "id";
	public static final String fieldIdUtilisateur = "id_utilisateur";
	public static final String fieldIdSource = "id_source";

	public int id;
	public int id_utilisateur;
	public int id_source;

	public AbonnementRelation() {
		super();
		tableName = "blacklistage_utilisateur_relation";
		defautUpdateColumns = new String[] { "id",
				"id_utilisateur", "id_source" };
	}

	public AbonnementRelation(int id, int id_utilisateur, int id_source) {
		this();
		this.id = id;
		this.id_utilisateur = id_utilisateur;
		this.id_source = id_source;
	}
	
	

}
