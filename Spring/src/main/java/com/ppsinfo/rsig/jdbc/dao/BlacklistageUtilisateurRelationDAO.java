package com.ppsinfo.rsig.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ppsinfo.rsig.jdbc.model.*;

public interface BlacklistageUtilisateurRelationDAO extends BasicDataDAO{
	ArrayList<Source> listeSourceMasqueeByIdUser(int idu) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;
	ArrayList<Integer> listeIdSourceMasqueeByIdUser(int idu) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;
	//Dispo = non masqué par utilisateur, ni par le systeme
	ArrayList<Source> listeSourceDispoByIdUser(int idu) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException;
}
