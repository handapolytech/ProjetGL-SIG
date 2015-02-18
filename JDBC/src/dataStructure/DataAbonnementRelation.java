package dataStructure;

import java.sql.ResultSet;

public class DataAbonnementRelation extends Data {

	public static final String fieldId = "id";
	public static final String fieldIdUtilisateur = "id_utilisateur";
	public static final String fieldIdSource = "id_source";

	public int id;
	public int id_utilisateur;
	public int id_source;

	public static String tableName = "abonnement_relation";
	public static String[] defautUpdateColums = new String[] { "id",
			"id_utilisateur", "id_source" };

	public DataAbonnementRelation() {
		super();
	}

	public DataAbonnementRelation(int id, int id_utilisateur, int id_source) {
		this();
		this.id = id;
		this.id_utilisateur = id_utilisateur;
		this.id_source = id_source;
	}

	public DataAbonnementRelation(int id_utilisateur, int id_source) {
		this(0, id_utilisateur, id_source);
	}

}
