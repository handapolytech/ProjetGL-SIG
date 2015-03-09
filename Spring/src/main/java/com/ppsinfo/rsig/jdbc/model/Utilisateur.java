package com.ppsinfo.rsig.jdbc.model;

public class Utilisateur extends BasicData{

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
	
	public Utilisateur(){
		super();
		tableName = "utilisateur";
		defautUpdateColumns = new String[]{"id","nom","email","role","alert_frequence"};		
	}

	public Utilisateur(int id, String nom, String email, String role,
			int alert_frequence) {
		this();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.role = role;
		this.alert_frequence = alert_frequence;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", email=" + email
				+ ", role=" + role + ", alert_frequence=" + alert_frequence
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getAlert_frequence() {
		return alert_frequence;
	}

	public void setAlert_frequence(int alert_frequence) {
		this.alert_frequence = alert_frequence;
	}
	
	
}
