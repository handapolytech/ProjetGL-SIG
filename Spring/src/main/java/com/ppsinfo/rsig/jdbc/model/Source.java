package com.ppsinfo.rsig.jdbc.model;

public class Source extends BasicData {

	public static final String fieldId = "id";
	public static final String fieldUrlFournisseur = "url_fournisseur";
	public static final String fieldTitre = "titre";
	public static final String fieldNiveau = "niveau";
	public static final String fieldZone = "zone";
	public static final String fieldProjection = "projection";
	public static final String fieldPeriodicite = "periodicite";
	public static final String fieldDescription = "description";

	public int id;
	public String url_fournisseur;
	public String titre;
	public String niveau;
	public String zone;
	public String projection;
	public int periodicite;
	public String description;

	public Source() {
		super();
		tableName = "source";
		defautUpdateColumns = new String[] { "id", "url_fournisseur",
				"titre", "niveau", "zone", "projection", "periodicite",
				"description" };
	}

	
	public Source(int id, String url_fournisseur, String titre,
			String niveau, String zone, String projection, int periodicite,
			String description) {
		this();
		this.id = id;
		this.url_fournisseur = url_fournisseur;
		this.titre = titre;
		this.niveau = niveau;
		this.zone = zone;
		this.projection = projection;
		this.periodicite = periodicite;
		this.description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUrl_fournisseur() {
		return url_fournisseur;
	}


	public void setUrl_fournisseur(String url_fournisseur) {
		this.url_fournisseur = url_fournisseur;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getNiveau() {
		return niveau;
	}


	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}


	public String getZone() {
		return zone;
	}


	public void setZone(String zone) {
		this.zone = zone;
	}


	public String getProjection() {
		return projection;
	}


	public void setProjection(String projection) {
		this.projection = projection;
	}


	public int getPeriodicite() {
		return periodicite;
	}


	public void setPeriodicite(int periodicite) {
		this.periodicite = periodicite;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	

}
