package com.ppsinfo.rsig.jdbc.model;

import java.util.Date;

public class AlerteRelation extends BasicData {

	public static final String fieldId = "id";
	public static final String fieldIdUtilisateur = "id_utilisateur";
	public static final String fieldIdSource = "id_source";
	public static final String fieldPriorite = "priorite";
	public static final String fieldDate = "date";
	public static final String fieldSujet = "sujet";
	public static final String fieldType = "type";
	public static final String fieldStatut = "statut";
	public static final String fieldDescription = "description";
	
	public static final int defautValuePeriodicite = 7;

	public int id;
	public int id_utilisateur;
	public int id_source;
	public int priorite;
	public Date date;
	public String sujet;
	public String type;
	public String statut;
	public String description;

	public AlerteRelation() {
		super();
		tableName = "alerte_relation";
		defautUpdateColumns = new String[] { "id",
				"id_utilisateur", "id_source", "priorite", "date", "sujet", "type",
				"statut", "description" };
	}

	public AlerteRelation(int id, int id_utilisateur, int id_source,
			int priorite, Date date, String sujet, String type, String statut,
			String description) {
		this();
		this.id = id;
		this.id_utilisateur = id_utilisateur;
		this.id_source = id_source;
		this.priorite = priorite;
		this.date = date;
		this.sujet = sujet;
		this.type = type;
		this.statut = statut;
		this.description = description;
	}

	@Override
	public String toString() {
		return "AlerteRelation [id=" + id + ", id_utilisateur="
				+ id_utilisateur + ", id_source=" + id_source + ", priorite="
				+ priorite + ", date=" + date + ", sujet=" + sujet + ", type="
				+ type + ", statut=" + statut + ", description=" + description
				+ "]";
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

	public int getPriorite() {
		return priorite;
	}

	public void setPriorite(int priorite) {
		this.priorite = priorite;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
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

	

}
