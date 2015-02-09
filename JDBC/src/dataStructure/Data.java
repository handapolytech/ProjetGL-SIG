package dataStructure;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Data implements Serializable{
	
	//A définir pour toutes les sous classes
	public static String tableName;
	//les noms de tous les colonnes
	public static String[] defautUpdateColums;
	/**
	 * Constructeur à récrire dans chaque sous classe pour 
	 * mettre valeurs aux attributs static	
	 */
	public Data(){
		super();
	}
	
	public Data(ResultSet resultSet) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException{
		this();
		for (String columnName : defautUpdateColums) {
			Class c = Data.class;
			Field field = c.getDeclaredField(columnName);
			field.set(this, resultSet.getObject(columnName));
		}
	}
	
	
	
	//Information de connexion
	private String[] dbInfo = new String[3];
	
	
	public static  String getTableName() {
		return tableName;
	}


	public static String[] getDefautUpdateColums() {
		return defautUpdateColums;
	}
	
	
}
