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
public class DemandeModifController {
	
	private static final Logger logger = LoggerFactory.getLogger(DemandeModifController.class);
	
	
	/**Bloc DemandeModifRelation **/
	
	//Par défaut, accéder à la page de consultation des demandeModifRelations
	@RequestMapping(value = "/admin/demandemodif/", method = RequestMethod.GET)
    public ModelAndView demandeModifRelationDefaut(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		DemandeModifRelationDAO demandeModifRelationDAO = ctx.getBean("demandeModifRelationDAO", DemandeModifRelationDAO.class);
		//Récupérer la liste des demandeModifRelations et le transmettre à la page
		ArrayList<DemandeModifRelation> alDemandeModifRelation = (ArrayList<DemandeModifRelation>) demandeModifRelationDAO.selectAll();
        return new ModelAndView("admin/demandemodif/consulter","demandeModifRelations",alDemandeModifRelation);	
    }
	
	
	@RequestMapping(value = "/admin/demandemodif/modif", method = RequestMethod.GET)
    public ModelAndView demandeModifRelationDetail(@RequestParam("id")int id,Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		DemandeModifRelationDAO demandeModifRelationDAO = ctx.getBean("demandeModifRelationDAO", DemandeModifRelationDAO.class);
		DemandeModifRelation demandeModifRelation = (DemandeModifRelation) demandeModifRelationDAO.selectById(id);
		if (demandeModifRelation == null) {
			model.addAttribute("msgInfo", "Erreur selection: Aucune theme a pour id "+demandeModifRelation.getId());
			return new ModelAndView("admin/demandemodif/consulter","rien",null); 
		}else {
			//Mettre les attributs dans la page générée
			model.addAttribute("demandeModifRelation",demandeModifRelation);
			return new ModelAndView("admin/demandemodif/modif", "demandeModifRelation", demandeModifRelation);
		}
    }
	
	
	
	@RequestMapping(value = "/admin/demandemodif/consulter", method = RequestMethod.GET)
    public ModelAndView demandeModifRelationConsulter(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		DemandeModifRelationDAO demandeModifRelationDAO = ctx.getBean("demandeModifRelationDAO", DemandeModifRelationDAO.class);
		//Récupérer la liste des demandeModifRelations et le transmettre à la page
		ArrayList<DemandeModifRelation> alDemandeModifRelation = (ArrayList<DemandeModifRelation>) demandeModifRelationDAO.selectAll();
        return new ModelAndView("admin/demandemodif/consulter","demandeModifRelations",alDemandeModifRelation);
    }
	
	
	@RequestMapping(value = "/admin/demandemodif/suppr", method = RequestMethod.GET)
    public ModelAndView sourcSuppr(@RequestParam("id")int id,Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		DemandeModifRelationDAO demandeModifRelationDAO = ctx.getBean("demandeModifRelationDAO", DemandeModifRelationDAO.class);
        DemandeModifRelation demandeModifRelation = (DemandeModifRelation) demandeModifRelationDAO.selectById(id);
		if (demandeModifRelation == null) {
			model.addAttribute("msgInfo", "Erreur suppression: Aucune demandeModifRelation a pour id "+id);
		}else {
			if (demandeModifRelationDAO.deleteById(id)>0) {
				model.addAttribute("msgInfo", "Suppression réussie: Le demandeModifRelation a été supprimée"+id);
			}else {
				model.addAttribute("msgInfo", "Erreur suppression: Aucune demandeModifRelation a pour id "+id);
			}
		}
		ArrayList<DemandeModifRelation> alDemandeModifRelation = (ArrayList<DemandeModifRelation>) demandeModifRelationDAO.selectAll();
        return new ModelAndView("admin/demandemodif/consulter","demandeModifRelations",alDemandeModifRelation); 
    }
	
	 
	
}
