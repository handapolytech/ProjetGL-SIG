package dataStructure;

public class DataAlerteRelation extends Data{

	public static final String fieldIdUtilisateur = "id_utilisateur";
	public static final String fieldIdSource = "id_source";
	public static final String fieldPriorite = "priorite";
	public static final String fieldIdSource = "id_source";
	public static final String fieldIdSource = "id_source";
	public static final String fieldIdSource = "id_source";
	
	
	
	public int id;
	public int id_utilisateur;
	public int id_source;
	
	public static String tableName = "alerte_relation";		
	public static String[] defautUpdateColums = new String[]{"id_utilisateur","id_source"};
	
	public DataAlerteRelation(){
		super();
	}
	
	public DataAlerteRelation(int id, int id_utilisateur, int id_source) {
		this();
		this.id = id;
		this.id_utilisateur = id_utilisateur;
		this.id_source = id_source;
	}
	
	public DataAlerteRelation(int id_utilisateur, int id_source){
		this(0,id_utilisateur,id_source);
	}

}
