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
		tableName = "abonnement_relation";
		defautUpdateColumns = new String[] { "id",
				"id_utilisateur", "id_source" };
	}

	public AbonnementRelation(int id, int id_utilisateur, int id_source) {
		this();
		this.id = id;
		this.id_utilisateur = id_utilisateur;
		this.id_source = id_source;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public int getId_source() {
		return id_source;
	}

	public void setId_source(int id_source) {
		this.id_source = id_source;
	}

	@Override
	public String toString() {
		return "AbonnementRelation [id=" + id + ", id_utilisateur="
				+ id_utilisateur + ", id_source=" + id_source + "]";
	}
	
	

}
