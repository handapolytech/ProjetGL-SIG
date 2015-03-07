package com.ppsinfo.rsig.jdbc.model;

import java.util.Date;

public class Version extends BasicData {

	public static final String fieldId = "id";
	public static final String fieldIdSource = "id_source";
	public static final String fieldUrlServeur = "url_serveur";
	public static final String fieldVersion = "version";
	public static final String fieldDateCreationFournisseur = "date_creation_fournisseur";

	public int id;
	public int id_source;
	public String url_serveur;
	public String version;
	public Date date_creation_fournisseur;

	public Version() {
		super();
		tableName = "version";
		defautUpdateColumns = new String[] { "id",
				"id_source", "url_serveur", "version", "date_creation_fournisseur"};
	}

	public Version(int id, int id_source, String url_serveur,
			String version, Date date_creation_fournisseur) {
		this();
		this.id = id;
		this.id_source = id_source;
		this.url_serveur = url_serveur;
		this.version = version;
		this.date_creation_fournisseur = date_creation_fournisseur;
	}

}
