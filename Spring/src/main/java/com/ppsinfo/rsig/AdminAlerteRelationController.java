package com.ppsinfo.rsig;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ppsinfo.rsig.jdbc.dao.*;
import com.ppsinfo.rsig.jdbc.model.*;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminAlerteRelationController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminAlerteRelationController.class);
	
	
	/**Bloc AlerteRelation **/
	
	//Par défaut, accéder à la page de consultation des alerteRelations
	@RequestMapping(value = "/admin/alerterelation/", method = RequestMethod.GET)
    public ModelAndView alerteRelationDefaut(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AlerteRelationDAO alerteRelationDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
		//Récupérer la liste des alerteRelations et le transmettre à la page
		ArrayList<AlerteRelation> alAlerteRelation = (ArrayList<AlerteRelation>) alerteRelationDAO.selectWhere("id_source=1");
        return new ModelAndView("admin/alerterelation/consulter","alerteRelations",alAlerteRelation);	
    }
	
	@RequestMapping(value = "/admin/alerterelation/ajout", method = RequestMethod.GET)
    public ModelAndView sourceAjout(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		//Récupérer la liste des utilisateurs
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		UtilisateurDAO userDAO = ctx.getBean("utilisateurDAO", UtilisateurDAO.class);
		ArrayList<Utilisateur>alUser = (ArrayList<Utilisateur>) userDAO.selectAll();
		return new ModelAndView("admin/alerterelation/ajout", "users", alUser);
	}
	
	/*
	 * Traiter l'ajout et la modification d'une alerteRelation
	 */
	@RequestMapping(value = "/admin/alerterelation/modif", method = RequestMethod.POST)
    public ModelAndView alerteRelationAjoutModif(@Validated com.ppsinfo.rsig.jdbc.model.AlerteRelation alerteRelation, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AlerteRelationDAO alerteRelationDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
        //Insérer alerteRelation dans son tableau et récupérer son id dans idAlerteRelation
		//si id = 0, le alerteRelation est nouvelle et on l'insère dans la BD
		//sinon, c'est une alerteRelation existante et on l'affiche
		if (alerteRelation.getId() == 0) {
			//insert
			alerteRelation.setDate(new Date());
			alerteRelation.setId(alerteRelationDAO.insert(alerteRelation));
			model.addAttribute("msgInfo", "<p>Ajout éffectuée</p>");
		}else {
			//update
			alerteRelationDAO.update(alerteRelation);
			model.addAttribute("msgInfo", "<p>Modification éffectuée</p>");
		}
        //Mettre les attributs dans la page générée
		model.addAttribute("alerteRelation", alerteRelation);
		//Les utilisateur
		UtilisateurDAO userDAO = ctx.getBean("utilisateurDAO", UtilisateurDAO.class);
		ArrayList<Utilisateur>alUser = (ArrayList<Utilisateur>) userDAO.selectAll();
		//Crée le map
		Map<String, Object> modelsMap = new HashMap<String, Object>();
		modelsMap.put("users", alUser);
		modelsMap.put("alerteRelation", alerteRelation);
		return new ModelAndView("admin/alerterelation/modif", modelsMap);
    }
	
	
	@RequestMapping(value = "/admin/alerterelation/modif", method = RequestMethod.GET)
    public ModelAndView alerteRelationDetail(@RequestParam("id")int id,Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AlerteRelationDAO alerteRelationDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
		AlerteRelation alerteRelation = (AlerteRelation) alerteRelationDAO.selectById(id);
		if (alerteRelation == null) {
			model.addAttribute("msgInfo", "Erreur selection: Aucune theme a pour id "+alerteRelation.getId());
			return new ModelAndView("admin/alerterelation/consulter","rien",null); 
		}else {
			//Mettre les attributs dans la page générée
			model.addAttribute("alerteRelation",alerteRelation);
			return new ModelAndView("admin/alerterelation/modif", "alerteRelation", alerteRelation);
		}
    }
	
	
	
	@RequestMapping(value = "/admin/alerterelation/consulter", method = RequestMethod.GET)
    public ModelAndView alerteRelationConsulter(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AlerteRelationDAO alerteRelationDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
		//Récupérer la liste des alerteRelations et le transmettre à la page
		ArrayList<AlerteRelation> alAlerteRelation = (ArrayList<AlerteRelation>) alerteRelationDAO.selectWhere("id_source=1");
        return new ModelAndView("admin/alerterelation/consulter","alerteRelations",alAlerteRelation);
    }
	
	
	@RequestMapping(value = "/admin/alerterelation/suppr", method = RequestMethod.GET)
    public ModelAndView sourcSuppr(@RequestParam("id")int id,Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AlerteRelationDAO alerteRelationDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
        AlerteRelation alerteRelation = (AlerteRelation) alerteRelationDAO.selectById(id);
		if (alerteRelation == null) {
			model.addAttribute("msgInfo", "Erreur suppression: Aucune alerteRelation a pour id "+id);
		}else {
			if (alerteRelationDAO.deleteById(id)>0) {
				model.addAttribute("msgInfo", "Suppression réussie: Le alerteRelation a été supprimée"+id);
			}else {
				model.addAttribute("msgInfo", "Erreur suppression: Aucune alerteRelation a pour id "+id);
			}
		}
		ArrayList<AlerteRelation> alAlerteRelation = (ArrayList<AlerteRelation>) alerteRelationDAO.selectWhere("id=1");
        return new ModelAndView("admin/alerterelation/consulter","alerteRelations",alAlerteRelation); 
    }
	
	 
	
}
