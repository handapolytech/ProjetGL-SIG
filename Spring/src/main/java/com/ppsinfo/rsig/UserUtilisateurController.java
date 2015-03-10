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
public class UserUtilisateurController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserUtilisateurController.class);
	//TODO Remplacer ca par la variable dans la session!!!
	int idUser = 1;
	
	/**Bloc Utilisateur **/
	
	//Par défaut, accéder à la page de consultation des utilisateurs
	@RequestMapping(value = "/user/utilisateur/", method = RequestMethod.GET)
    public ModelAndView utilisateurDefaut(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		UtilisateurDAO utilisateurDAO = ctx.getBean("utilisateurDAO", UtilisateurDAO.class);
		Utilisateur utilisateur = (Utilisateur) utilisateurDAO.selectById(idUser);
		if (utilisateur == null) {
			//model.addAttribute("msgInfo", "Erreur selection: Aucune utilisateur a pour id "+utilisateur.getId());
			return new ModelAndView("home","rien",null); 
		}else {
			//Mettre les attributs dans la page générée
	        return new ModelAndView("user/utilisateur/modif","utilisateur", utilisateur);
		}
    }
	
	
	/*
	 * Traiter la modification d'une utilisateur
	 */
	@RequestMapping(value = "/user/utilisateur/modif", method = RequestMethod.POST)
    public ModelAndView utilisateurAjoutModif(@Validated com.ppsinfo.rsig.jdbc.model.Utilisateur utilisateur, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		UtilisateurDAO utilisateurDAO = ctx.getBean("utilisateurDAO", UtilisateurDAO.class);
			//update
			utilisateurDAO.update(utilisateur);
			model.addAttribute("msgInfo", "<p>Modification éffectuée</p>");
		
        //Mettre les attributs dans la page générée
        return new ModelAndView("user/utilisateur/modif","utilisateur",utilisateur);
    }
	
	@RequestMapping(value = "/user/utilisateur/modif", method = RequestMethod.GET)
    public ModelAndView utilisateurDetail(Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		UtilisateurDAO utilisateurDAO = ctx.getBean("utilisateurDAO", UtilisateurDAO.class);
        Utilisateur utilisateur = (Utilisateur) utilisateurDAO.selectById(idUser);
		if (utilisateur == null) {
			//model.addAttribute("msgInfo", "Erreur selection: Aucune utilisateur a pour id "+utilisateur.getId());
			return new ModelAndView("home","rien",null); 
		}else {
			//Mettre les attributs dans la page générée
	        return new ModelAndView("user/utilisateur/modif","utilisateur", utilisateur);
		}
    }

	 
	
}
