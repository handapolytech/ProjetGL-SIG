package com.ppsinfo.rsig;

import java.sql.SQLException;
import java.util.ArrayList;

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
public class UserAbonnementRelationController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserAbonnementRelationController.class);
	//TODO Remplacer ca par la variable dans la session!!!
		int idUser = 1;
	
	/**Bloc AbonnementRelation **/
	
	//Par défaut, accéder à la page de consultation des abonnementRelations
	@RequestMapping(value = "/user/abonnement/", method = RequestMethod.GET)
    public ModelAndView abonnementRelationDefaut(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AbonnementRelationDAO abonnementRelationDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
		//Récupérer la liste des abonnementRelations et le transmettre à la page
		ArrayList<AbonnementRelation> alAbonnementRelation = (ArrayList<AbonnementRelation>) abonnementRelationDAO.selectWhere("id_utilisateur="+idUser);
        return new ModelAndView("user/abonnement/consulter","abonnementRelations",alAbonnementRelation);	
    }

	/*
	 * Traiter l'ajout et la modification d'une abonnementRelation
	 */
	@RequestMapping(value = "/user/abonnement/modif", method = RequestMethod.POST)
    public ModelAndView abonnementRelationAjoutModif(@Validated com.ppsinfo.rsig.jdbc.model.AbonnementRelation abonnementRelation, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AbonnementRelationDAO abonnementRelationDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
        //Insérer abonnementRelation dans son tableau et récupérer son id dans idAbonnementRelation
		//si id = 0, le abonnementRelation est nouvelle et on l'insère dans la BD
		//sinon, c'est une abonnementRelation existante et on l'affiche
		if (abonnementRelation.getId() == 0) {
			//insert
			abonnementRelation.setId(abonnementRelationDAO.insert(abonnementRelation));
			model.addAttribute("msgInfo", "<p>Ajout éffectuée</p>");
		}else {
			//update
			abonnementRelationDAO.update(abonnementRelation);
			model.addAttribute("msgInfo", "<p>Modification éffectuée</p>");
		}
        //Mettre les attributs dans la page générée
        return new ModelAndView("user/abonnement/modif","abonnementRelation",abonnementRelation);
    }
	
	//Affichage du détail avec id passé par GET
	@RequestMapping(value = "/user/abonnement/modif", method = RequestMethod.GET)
    public ModelAndView abonnementRelationDetail(@RequestParam("id")int id,Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AbonnementRelationDAO abonnementRelationDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
        AbonnementRelation abonnementRelation = (AbonnementRelation) abonnementRelationDAO.selectById(id);
		if (abonnementRelation == null) {
			model.addAttribute("msgInfo", "Erreur selection: Aucune abonnementRelation a pour id "+abonnementRelation.getId());
			return new ModelAndView("user/abonnement/consulter","rien",null); 
		}else {
			//Mettre les attributs dans la page générée
			return new ModelAndView("user/abonnement/modif","abonnementRelation",abonnementRelation);
		}
    }
	
	//Pour retourner la page de la liste
	@RequestMapping(value = "/user/abonnement/consulter", method = RequestMethod.GET)
    public ModelAndView abonnementRelationConsulter(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AbonnementRelationDAO abonnementRelationDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
		//Récupérer la liste des abonnementRelations et le transmettre à la page
		ArrayList<AbonnementRelation> alAbonnementRelation = (ArrayList<AbonnementRelation>) abonnementRelationDAO.selectWhere("id_utilisateur="+idUser);
        return new ModelAndView("user/abonnement/consulter","abonnementRelations",alAbonnementRelation);
    }
	
	//Traiter la suppression
	@RequestMapping(value = "/user/abonnement/suppr", method = RequestMethod.GET)
    public ModelAndView sourcSuppr(@RequestParam("id")int id,Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		AbonnementRelationDAO abonnementRelationDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
        AbonnementRelation abonnementRelation = (AbonnementRelation) abonnementRelationDAO.selectById(id);
		if (abonnementRelation == null) {
			model.addAttribute("msgInfo", "Erreur suppression: Aucune abonnementRelation a pour id "+id);
		}else {
			if (abonnementRelationDAO.deleteById(id)>0) {
				model.addAttribute("msgInfo", "Suppression réussie: Le abonnementRelation a été supprimée"+id);
			}else {
				model.addAttribute("msgInfo", "Erreur suppression: Aucune abonnementRelation a pour id "+id);
			}
		}
		ArrayList<AbonnementRelation> alAbonnementRelation = (ArrayList<AbonnementRelation>) abonnementRelationDAO.selectWhere("id_utilisateur="+idUser);
        return new ModelAndView("user/abonnement/consulter","abonnementRelations",alAbonnementRelation); 
    }
	
	 
	
}
