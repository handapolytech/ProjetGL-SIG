package dataStructure;

public class DataUtilisateur extends Data{

	public static final String fieldId = "id";
	public static final String fieldNom = "nom";
	public static final String fieldEmail = "email";
	public static final String fieldRole = "role";
	public static final String fieldAlertFrequence = "alert_frequence";
	
	public int id;
	public String nom;
	public String email;
	public String role;
	public int alert_frequence;
	
	public DataUtilisateur(){
		super();
		tableName = "utilisateur";
		defautUpdateColumns = new String[]{"id","nom","email","role","alert_frequence"};		
	}
	
	
}
