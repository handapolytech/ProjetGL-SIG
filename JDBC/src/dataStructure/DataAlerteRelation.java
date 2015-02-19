package dataStructure;

import java.util.Date;

public class DataAlerteRelation extends Data {

	public static final String fieldId = "id";
	public static final String fieldIdUtilisateur = "id_utilisateur";
	public static final String fieldIdSource = "id_source";
	public static final String fieldPriorite = "priorite";
	public static final String fieldDate = "date";
	public static final String fieldSujet = "sujet";
	public static final String fieldType = "type";
	public static final String fieldStatut = "statut";
	public static final String fieldDescription = "description";

	public int id;
	public int id_utilisateur;
	public int id_source;
	public int priorite;
	public Date date;
	public String sujet;
	public String type;
	public String statut;
	public String description;

	public DataAlerteRelation() {
		super();
		tableName = "alerte_relation";
		defautUpdateColumns = new String[] { "id",
				"id_utilisateur", "id_source", "priorite", "date", "sujet", "type",
				"statut", "description" };
	}

	public DataAlerteRelation(int id, int id_utilisateur, int id_source,
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


}
