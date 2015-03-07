package com.ppsinfo.rsig;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ppsinfo.rsig.jdbc.dao.*;
import com.ppsinfo.rsig.jdbc.model.*;

public class JDBCTests {
	private String tableName;
	private int insert;
	private String selectById;
	private int update;
	private String resultatUpdate; 
	private int selectAll;
	private String ligne1;
	private String condition;
	private int selectWhere;
	private String ligne11;
	private int deleteById;
	
	//Ligne pour afficher l'information de débug
	private String debugLine;
    
	public void generateAttributes() throws SQLException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException{
		//Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        //Get the EmployeeDAO Bean
        BasicDataDAO dataDAO = null;
        BasicData newData = null;
        
        
        if (tableName.equals("test")) {
			dataDAO = ctx.getBean("testDAO", TestDAO.class);
			//insert
			newData = new Test(0, 99, "Hello", "sample", new Date());
		}else if (tableName.equals("utilisateur")) {
			dataDAO = ctx.getBean("utilisateurDAO", UtilisateurDAO.class);
			//insert
			newData = new Utilisateur(0, "handa", "handa-upsud", "admin", 30);
		}else if (tableName.equals("source")) {
			dataDAO = ctx.getBean("sourceDAO", SourceDAO.class);
			//insert
			newData = new Source(0, "http", "srouce1", "haut", "France", "vertical", 10, "test");
		}else if (tableName.equals("theme")) {
			dataDAO = ctx.getBean("themeDAO", ThemeDAO.class);
			//insert
			newData = new Theme(0, "testTheme");
		}else if (tableName.equals("themeRelation")) {
			dataDAO = ctx.getBean("themeRelationDAO", ThemeRelationDAO.class);
			//insert
			newData = new ThemeRelation(0, 1, 1);
		}else if (tableName.equals("version")) {
			dataDAO = ctx.getBean("versionDAO", VersionDAO.class);
			//insert
			newData = new Version(0, 1, "url_serveur", "version", new Date());
		}else if (tableName.equals("abonnementRelation")) {
			dataDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
			//insert
			newData = new AbonnementRelation(0, 1, 1);
		}else if (tableName.equals("alerteRelation")) {
			dataDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
			//insert
			newData = new AlerteRelation(0, 1, 1, 15, new Date(), "sujet", "type", "statut", "description");
		}else if (tableName.equals("blacklistageSysteme")) {
			dataDAO = ctx.getBean("blacklistageSystemeDAO", BlacklistageSystemeDAO.class);
			//insert
			newData = new BlacklistageSysteme(0, 1);
		}else if (tableName.equals("blacklistageUtilisateurRelation")) {
			dataDAO = ctx.getBean("blacklistageUtilisateurRelationDAO", BlacklistageUtilisateurRelationDAO.class);
			//insert
			newData = new BlacklistageUtilisateurRelation(0, 1, 1);
		}else if (tableName.equals("demandeModifRelation")) {
			dataDAO = ctx.getBean("demandeModifRelationDAO", DemandeModifRelationDAO.class);
			//insert
			newData = new DemandeModifRelation(0, 1, 1, new Date(), "type", "statut", "description");
		}
        
        
        this.insert = dataDAO.insert(newData);
        //selecById
        BasicData t = dataDAO.selectById(this.insert);
        if (t!=null) {
			this.selectById = t.toString();
		}else {
			this.selectById = "rien";
		}
        //update
        this.update = dataDAO.update(t);
        t = dataDAO.selectById(this.insert);
        if (t!=null) {
			this.resultatUpdate = t.toString();
		}else {
			this.resultatUpdate = "rien";
		}
        //selectAll
        ArrayList<? extends BasicData> alTest = dataDAO.selectAll();
        this.selectAll = alTest.size();
        if (alTest.size()==0) {
        	this.ligne1 = "rien";
		}else {
			this.ligne1 = alTest.get(0).toString();
		}
        //selectWhere
        String condition = "id > 1";
        this.condition = condition;
        ArrayList<? extends BasicData> alTest1 = dataDAO.selectWhere(condition);
        this.selectWhere = alTest1.size();
        if (alTest1.size()==0) {
        	this.ligne11 = "rien";
		}else {
			this.ligne11 = alTest1.get(0).toString();
		}
        //deleteById
        this.deleteById = 99;
        //this.deleteById = dataDAO.deleteById(insert);
    }
	
	public String getTableName() {
        return tableName;
    }
 
    public void setTableName(String userName) {
        this.tableName = userName;
    }

	public int getInsert() {
		return insert;
	}
    
	
	
	
	
    public String getSelectById() {
		return selectById;
	}

	public int getUpdate() {
		return update;
	}

	public String getResultatUpdate() {
		return resultatUpdate;
	}

	public int getSelectAll() {
		return selectAll;
	}

	public String getLigne1() {
		return ligne1;
	}

	public String getCondition() {
		return condition;
	}

	public int getSelectWhere() {
		return selectWhere;
	}

	public String getLigne11() {
		return ligne11;
	}

	public int getDeleteById() {
		return deleteById;
	}

	public String getDebugLine() {
		return debugLine;
	}

	
}
