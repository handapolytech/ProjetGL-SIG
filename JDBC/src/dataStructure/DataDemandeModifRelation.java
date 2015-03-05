package dataStructure;

import java.util.Date;

public class DataDemandeModifRelation extends Data {

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

	public DataDemandeModifRelation() {
		super();
		tableName = "demande_modif_relation";
		defautUpdateColumns = new String[] { "id",
				"id_utilisateur", "id_source", "date", "type",
				"statut", "description" };
	}

	
	public DataDemandeModifRelation(int id, int id_utilisateur, int id_source,
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

}
