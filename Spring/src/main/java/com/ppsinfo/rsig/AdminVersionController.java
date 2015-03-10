package com.ppsinfo.rsig;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.VersionSpecHelper;
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
public class AdminVersionController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminVersionController.class);
	
	
	/**Bloc Version **/
	
	
	//Formulaire pour ajouter
	@RequestMapping(value = "/admin/version/ajout", method = RequestMethod.GET)
    public String sourceAjout(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		model.addAttribute("id_source", request.getParameter("id_source"));
		return "admin/version/ajout";	
	}
	
	/*
	 * Traiter l'ajout d'une version
	 */
	@RequestMapping(value = "/admin/version/modif", method = RequestMethod.POST)
    public ModelAndView versionAjoutModif(@Validated com.ppsinfo.rsig.jdbc.model.Version version, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, IOException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		VersionDAO versionDAO = ctx.getBean("versionDAO", VersionDAO.class);
        //Insérer version dans son tableau et récupérer son id dans idVersion
		version.setDate_creation_fournisseur(new Date());
		version.setId(versionDAO.insert(version));
		String cheminRep = "C:/ressources/"+version.id_source+"/";
		if (versionDAO.downloadVersion(version.url_serveur,cheminRep )) {
			model.addAttribute("msgInfo", "<p>Une nouvelle version est ajoutée avec son fichier</p>");
			//maj l'adresse
			String fileName = version.url_serveur.substring(version.url_serveur.lastIndexOf("/") + 1,
					version.url_serveur.length());
			fileName = cheminRep+fileName;
			version.setUrl_serveur(fileName);
		}else {
			model.addAttribute("msgInfo", "<p>Une nouvelle version est ajoutée mais le téléchargement de ficher a échoué</p>");
		}
		return new ModelAndView("admin/version/modif","version",version);
    }
	
	 
	
}
