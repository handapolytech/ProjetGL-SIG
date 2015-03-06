package com.ppsinfo.rsig.jdbc.model;

public class BasicData{

	// A définir pour toutes les sous classes
	public String tableName;
	// les noms de tous les colonnes
	public String[] defautUpdateColumns;

	/**
	 * Constructeur à récrire dans chaque sous classe pour mettre valeurs aux
	 * attributs static Attention, le seul cas où ce constructeur est autorisé à
	 * applé en hors des classes dataStructure est qaund on a besoin de créer
	 * une donnée "vide" puis compléter son contenu par des resultSet
	 * 
	 */
	public BasicData() {
		super();
	}

//	public Data(ResultSet resultSet) throws NoSuchFieldException,
//			SecurityException, IllegalArgumentException,
//			IllegalAccessException, SQLException {
//		this();
//		for (String columnName : defautUpdateColums) {
//			Class c = Data.class;
//			Field field = c.getDeclaredField(columnName);
//			field.set(this, resultSet.getObject(columnName));
//		}
//	}

	public String getTableName() {
		return tableName;
	}

	public  String[] getDefautUpdateColumns() {
		return defautUpdateColumns;
	}

}
