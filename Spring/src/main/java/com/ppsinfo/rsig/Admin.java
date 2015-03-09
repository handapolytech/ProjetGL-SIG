package com.ppsinfo.rsig;

public class Admin {
	public static final int ChoixSourceConsulter = 10;
	public static final int ChoixSourceAjout = 11;
	public static final int ChoixSourceModif = 12;
	public static final int ChoixSourceSuppr = 13;
	public static final int ChoixSourceAjoutVersion = 21;
	public static final int ChoixSourceSupprVersion = 22;
	public static final int ChoixThemeConsulter = 30;
	public static final int ChoixThemeAjout = 31;
	public static final int ChoixThemeModif = 32;
	public static final int ChoixThemeSuppr = 33;
//	public static final int ChoixUtilisateurConsulter = 41;
//	public static final int ChoixUtilisateurAjout = 41;
//	public static final int ChoixUtilisateurModif = 42;
//	public static final int ChoixUtilisateurSuppr = 43;
	public static final int ChoixBlacklisteSysConsulter = 50;
	public static final int ChoixBlacklisteSysAjout = 51;
	public static final int ChoixBlacklisteSysSuppr= 52;
	public static final int ChoixAlerteUtilisateurAjout = 91;
	public static final int ChoixListeDemandeModifConsulter = 92;

		
	
	
    private int choixFonction;

	public int getChoixFonction() {
		return choixFonction;
	}

	public void setChoixFonction(int choixFonction) {
		this.choixFonction = choixFonction;
	}
 
    
     
}