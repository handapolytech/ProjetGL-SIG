package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ppsinfo.rsig.jdbc.model.*;

public interface AbonnementRelationDAO extends BasicDataDAO{
	
	ArrayList<Integer> listeIdSourceByIdUtilisateur(int idu) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;
	
	ArrayList<Source> listSourceByIdUtilisateur(int idu) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;
	
	ArrayList<Source> listSourceByIdUtilisateurAvecMasquage(int idu) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;

}
