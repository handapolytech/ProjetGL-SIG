package dataStructure;
import java.io.Serializable;

public abstract class Data implements Serializable{
	
	//A définir pour toutes les sous classes
	public static String tableName;
	
	
	//!!Quand vous spécifiez le constructeur pour une sous classe,
	//Mettez 0 pour les nulls
	
	//Information de connexion
	private String[] dbInfo = new String[3];
	
	//les noms de tous les colonnes
	public abstract String[] defautUpdateColums();
	
	public String getTableName() {
		return tableName;
	}
	
	
}
