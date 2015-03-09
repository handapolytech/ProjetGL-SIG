package com.ppsinfo.rsig.jdbc.model;

import java.util.Date;

public class DemandeModifRelation extends BasicData {

	public static final String fieldId = "id";
	public static final String fieldIdUtilisateur = "id_utilisateur";
	public static final String fieldIdSource = "id_source";
	public static final String fieldDate = "date";
	public static final String fieldType = "type";
	public static final String fieldStatut = "statut";
	public static final String fieldDescription = "description";

	public int id;
	public int id_utilisateur;
	public int id_source;
	public Date date;
	public String type;
	public String statut;
	public String description;

	public DemandeModifRelation() {
		super();
		tableName = "demande_modif_relation";
		defautUpdateColumns = new String[] { "id",
				"id_utilisateur", "id_source", "date", "type",
				"statut", "description" };
	}

	
	public DemandeModifRelation(int id, int id_utilisateur, int id_source,
			Date date, String type, String statut, String description) {
		this();
		this.id = id;
		this.id_utilisateur = id_utilisateur;
		this.id_source = id_source;
		this.date = date;
		this.type = type;
		this.statut = statut;
		this.description = description;
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


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStatut() {
		return statut;
	}


	public void setStatut(String statut) {
		this.statut = statut;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "DemandeModifRelation [id=" + id + ", id_utilisateur="
				+ id_utilisateur + ", id_source=" + id_source + ", date="
				+ date + ", type=" + type + ", statut=" + statut
				+ ", description=" + description + "]";
	}

	
	
}
