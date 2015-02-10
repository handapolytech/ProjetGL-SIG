package dataStructure;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data implements Serializable {

	// A définir pour toutes les sous classes
	public static String tableName;
	// les noms de tous les colonnes
	public static String[] defautUpdateColums;

	/**
	 * Constructeur à récrire dans chaque sous classe pour mettre valeurs aux
	 * attributs static Attention, le seul cas où ce constructeur est autorisé à
	 * applé en hors des classes dataStructure est qaund on a besoin de créer
	 * une donnée "vide" puis compléter son contenu par des resultSet
	 * 
	 */
	public Data() {
		super();
	}

	public Data(ResultSet resultSet) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException {
		this();
		for (String columnName : defautUpdateColums) {
			Class c = Data.class;
			Field field = c.getDeclaredField(columnName);
			field.set(this, resultSet.getObject(columnName));
		}
	}

	// Information de connexion
	private String[] dbInfo = new String[3];

	public static String getTableName() {
		return tableName;
	}

	public static String[] getDefautUpdateColums() {
		return defautUpdateColums;
	}

}
