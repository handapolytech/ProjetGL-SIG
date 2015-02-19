import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.lang.reflect.*;
import java.lang.Class;

import javax.sound.sampled.DataLine;

import dataStructure.Data;
import dataStructure.DataTest;

public class CommonOperation {

	// Information de connexion
	// URL,user,password
	protected static String[] dbInfo = new String[] {
			"jdbc:mysql://localhost:3306/sig", "root", "" };
	protected static String dbName = "sig";
	protected static Connection conn = null;

	/* Fonctions réservé à utiliser à l'intérieur de la classe */
	// Début d'une connexion
	protected static Statement startConn() throws SQLException {
		conn = DriverManager.getConnection(dbInfo[0], dbInfo[1], dbInfo[2]);
		/* Création de l'objet gérant les requêtes */
		return conn.createStatement();
	}

	// Fin d'une connexion
	protected static void endConn() throws SQLException {
		conn.close();
	}

	/* Fonctions opérationnelles */
	/**
	 * Inserer une donnée dans la BD
	 * 
	 * @param data
	 *            la donnée à insérer
	 * @return nombre de ligne insérée
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	public static int insert(Data data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException {
		// statement pour exécuter une requete
		Statement statement = startConn();
		// résultat de l'exécution
		int result = 0;
		// Noms des colonnes
		String[] columNames = data.getDefautUpdateColumns();
		// Requete
		String sql = "INSERT INTO " + data.getTableName() + " VALUES (";
		// Ajouter les champs
		if (columNames.length > 1) {
			for (int i = 0; i < columNames.length - 1; i++) {
				Class<?> c = data.getClass();
				// Récupérer l'attribut de l'objet data qui prote le nom "name"
				Field field = c.getDeclaredField(columNames[i]);
				if (field.get(data) == null) {
					sql += "null,";
				} else {
					sql += "'" + field.get(data) + "',";
				}
			}
		}
		Class<?> c = data.getClass();
		// Récupérer l'attribut de l'objet data qui prote le nom "name"
		Field field = c.getDeclaredField(columNames[columNames.length - 1]);
		if (field.get(data) == null) {
			sql += "null,";
		} else if(field.get(data).getClass().equals(Date.class)){
			//Formater la date pour adapter au DateFormat de SQL
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			sql += "'" + df.format((Date)field.get(data)) + "'";
			
		}else {
			sql += "'" + field.get(data) + "'";
		}
		// compléter la fin de la requete
		sql += ")";
		// Exécuter la requete
		result = statement.executeUpdate(sql);
		endConn();
		return result;
	}

	/**
	 * Supprimer une donnée depuis son id
	 * 
	 * @param tableName
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static int deleteById(String tableName, int id) throws SQLException {
		// statement pour exécuter une requete
		Statement statement = startConn();
		// résultat de l'exécution
		int result = 0;
		// Requete
		String sql = "DELETE FROM " + tableName + " WHERE id=" + id;
		// Exécuter la requete
		result = statement.executeUpdate(sql);
		endConn();
		return result;
	}

	/**
	 * Modifier une donnée Attention: C'est l'id de data qui détermine la donnée
	 * à mettre à jour
	 * 
	 * @param data
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 */
	public static int updateById(Data data) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException {
		// statement pour exécuter une requete
		Statement statement = startConn();
		// résultat de l'exécution
		int result = 0;
		// Noms des colonnes
		String[] columNames = data.getDefautUpdateColumns();
		// Requete
		String sql = "UPDATE " + data.getTableName() + " SET ";
		// Ajouter les champs
		if (columNames.length > 1) {
			for (int i = 0; i < columNames.length - 1; i++) {
				if (!columNames[i].equals("id")) {
					Class<?> c = data.getClass();
					// Récupérer l'attribut de l'objet data qui prote le nom
					// "name"
					Field field = c.getDeclaredField(columNames[i]);
					if (field.get(data) == null) {
						sql += columNames[i] + "='',";
					} else {
						sql += columNames[i] + "='" + field.get(data) + "',";
					}
				}
			}
		}
		Class<?> c = data.getClass();
		// Récupérer l'attribut de l'objet data qui prote le nom "name"
		Field field = c.getDeclaredField(columNames[columNames.length - 1]);
		if (field.get(data) == null) {
			sql += columNames[columNames.length - 1] + "=''";
		} else if(field.get(data).getClass().equals(Date.class)){
			//Formater la date pour adapter au DateFormat de SQL
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			sql += columNames[columNames.length - 1] + "='" + df.format((Date)field.get(data))
			+ "'";
			
		}else {
			sql += columNames[columNames.length - 1] + "='" + field.get(data)
			+ "'";
		}
		// compléter la fin de la requet
		field = c.getDeclaredField("id");
		sql += " WHERE id=" + field.get(data);
		// debug
		// System.out.println(sql);
		// Exécuter la requete
		result = statement.executeUpdate(sql);
		endConn();
		return result;
	}
	/**
	 * Selectionner tous les données dans un tableau
	 * @param classT
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T extends Data> ArrayList<T> selectAll(Class<T> classT)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException, InvocationTargetException,
			NoSuchMethodException {
		// statement pour exécuter une requete
		Statement statement = startConn();
		// résultat de l'exécution
		ResultSet resultSet = null;
		// Noms des colonnes
		T dataInstance = classT.newInstance();
		String[] columnNames = dataInstance.getDefautUpdateColumns();
		// Requete
		String sql = "SELECT * FROM " + dataInstance.getTableName();
		resultSet = statement.executeQuery(sql);
		ArrayList<T> resultArray = new ArrayList<T>();
		while (resultSet.next()) {
			T t = classT.newInstance();
			for (String columnName : columnNames) {
				Field field = classT.getDeclaredField(columnName);
				field.set(t, resultSet.getObject(columnName));
			}
			resultArray.add(t);
		}

		endConn();
		return resultArray;
	}

	/**
	 * Mettre à jour une seule colone (pour la donnée qui a le même id que data)
	 * 
	 * @param data
	 * @param columnName
	 * @param content
	 * @return
	 * @throws SQLException
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static int updateSingleColumn(Data data, String columnName, String content)
			throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// statement pour exécuter une requete
		Statement statement = startConn();
		// résultat de l'exécution
		int result = 0;
		// Noms des colonnes
		String[] columNames = data.getDefautUpdateColumns();
		// Requete
		String sql = "UPDATE " + data.getTableName() + " SET ";
		Class<?> c = data.getClass();
		// Récupérer l'attribut de l'objet data qui prote le nom "columnName"
		Field field = c.getDeclaredField(columnName);
		if (field.get(data) == null) {
			sql += columnName+ "=''";
		} else {
			sql += columnName+ "='" + content
					+ "'";
		}
		// compléter la fin de la requet
		field = c.getDeclaredField("id");
		sql += " WHERE id=" + field.get(data);
		// debug
		// System.out.println(sql);
		// Exécuter la requete
		result = statement.executeUpdate(sql);
		endConn();
		return result;
	}
	

	/**
	 * Select avec condition where 
	 * @param classT
	 * @param condition
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public static <T extends Data> ArrayList<T> selectWhere(Class<T> classT,String condition)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException, InvocationTargetException,
			NoSuchMethodException {
		// statement pour exécuter une requete
		Statement statement = startConn();
		// résultat de l'exécution
		ResultSet resultSet = null;
		// Noms des colonnes
		T instanceData = classT.newInstance();
		String[] columnNames = instanceData.getDefautUpdateColumns();
		// Requete
		String sql = "SELECT * FROM " + instanceData.getTableName()+" WHERE "+condition;
		resultSet = statement.executeQuery(sql);
		ArrayList<T> resultArray = new ArrayList<T>();
		while (resultSet.next()) {
			T t = classT.newInstance();
			for (String columnName : columnNames) {
				Field field = classT.getDeclaredField(columnName);
				field.set(t, resultSet.getObject(columnName));
			}
			resultArray.add(t);
		}
		endConn();
		return resultArray;
	}
	
	
	// public IList<T> GenerateAllList<T>() where T : Data.BaseData, new();
	// public IList<T> GenerateAllList<T>(T baseData) where T : Data.BaseData,
	// new();
	// public T GenerateById<T>(string Id) where T : Data.BaseData, new();
	// public T GenerateById<T>(string Id, T baseData) where T : Data.BaseData,
	// new();
	// public string GenerateFormatPKey<T>(T baseData) where T : Data.BaseData,
	// new();
	// public IList<T> GenerateList<T>(ICriteria criteria) where T :
	// Data.BaseData, new();
	// public IList<T> GenerateList<T>(ICriteria criteria, T baseData) where T :
	// Data.BaseData, new();
	// public string GeneratePKey<T>(T baseData) where T : Data.BaseData, new();
	// public static CommonDBOperation Instance<T>() where T : Data.BaseData,
	// new();
	// public bool Update<T>(T baseData, string Id) where T : Data.BaseData,
	// new();
	// public bool Update<T>(T baseData, string Id, string[] updateColumns)
	// where T : Data.BaseData, new();
	public static void main(String[] args) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException,
			IllegalAccessException, SQLException, InstantiationException,
			InvocationTargetException, NoSuchMethodException {
/* Tests pour DataTest */
//		 DataTest data = new DataTest(0, 99999, "aaa", "Polytech",new Date());
//		 //insert Test
//		 System.out.println(CommonOperation.insert(data));
//		 //delete Test
//		 System.out.println(CommonOperation.deleteById(new DataTest().tableName,
//		 2));
//		 data.id = 4;
//		 data.num = 52;
//		 
//		 
//		 //update test
//		 System.out.println(CommonOperation.updateById(data));
//		 //select all test
//		 ArrayList<DataTest> al =
//		 CommonOperation.<DataTest>selectAll(DataTest.class);
//		 System.out.println(al.get(0).text);
//		 //update test pour le champ num
//		DataTest data1 = new DataTest(4, 9999, "helm", "opps",new Date());
//		System.out.println(CommonOperation.updateSingleColumn(data1, "num", "1"));
//		 //select from test where num = 1
//		 ArrayList<DataTest> al2 =
//		 CommonOperation.<DataTest>selectWhere(DataTest.class,"num < 99");
//		 if (al2.size()>0) {
//			 System.out.println(al2.get(0).date);
//		}
		
		/* Tests pour les vraies types */
		

	}

}
