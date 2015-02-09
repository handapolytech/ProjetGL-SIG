import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//		      Class.forName("com.mysql.jdbc.Driver");
//		      System.out.println("Driver O.K.");

		      String url = "jdbc:mysql://localhost:3306/sig";
		      String user = "root";
		      String passwd = "";

		      Connection conn = DriverManager.getConnection(url, user, passwd);
		      System.out.println("Connexion effective !");
		      
		      /* Création de l'objet gérant les requêtes */
		      Statement statement = conn.createStatement();
		      /* Exécution d'une requête de lecture */
		      ResultSet resultat = statement.executeQuery( "SELECT id, theme  FROM theme;" );
		      
		      conn.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } 

	}

}
