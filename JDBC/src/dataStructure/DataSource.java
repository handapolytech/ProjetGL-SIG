package dataStructure;

import java.util.Date;

public class DataSource extends Data {

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

	public DataSource() {
		super();
		tableName = "source";
		defautUpdateColumns = new String[] { "id", "url_fournisseur",
				"titre", "niveau", "zone", "projection", "periodicite",
				"description" };
	}

	
	public DataSource(int id, String url_fournisseur, String titre,
			String niveau, String zone, String projection, int periodicite,
			String description) {
		super();
		this.id = id;
		this.url_fournisseur = url_fournisseur;
		this.titre = titre;
		this.niveau = niveau;
		this.zone = zone;
		this.projection = projection;
		this.periodicite = periodicite;
		this.description = description;
	}

	

}
