package com.ppsinfo.rsig;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.taglibs.standard.lang.jstl.RelationalOperator;
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
public class UserSourceController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserSourceController.class);
	//TODO Remplacer ca par la variable dans la session!!!
			int idUser = 1;
	/** Bloc Source **/

	// Par défaut, accéder à la page de consultation des sources
	@RequestMapping(value = "/user/source/", method = RequestMethod.GET)
	public ModelAndView sourceDefaut(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		return pageConsulter(ctx, model);
	}

	
	// Afficher le détail
	@RequestMapping(value = "/user/source/modif", method = RequestMethod.GET)
	public ModelAndView sourceDetail(@RequestParam("id") int id, Model model)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		SourceDAO sourceDAO = ctx.getBean("sourceDAO", SourceDAO.class);
		Source source = (Source) sourceDAO.selectById(id);
		if (source == null) {
			model.addAttribute(
					"msgInfo",
					"Erreur selection: Aucune source a pour id "
							+ source.getId());
			ArrayList<Source> alSource = (ArrayList<Source>) sourceDAO
					.selectAll();
			return new ModelAndView("user/source/consulter", "sources",
					alSource);
		} else {
			ThemeRelationDAO trDAO = ctx.getBean("themeRelationDAO",
					ThemeRelationDAO.class);

			return pageModif(model, source, trDAO, ctx);
		}
	}
	
	// Abonner/désabonner
	@RequestMapping(value = "/user/source/abonner", method = RequestMethod.POST)
	public ModelAndView sourceAbonner(@RequestParam("id") int id,
			Model model, HttpServletRequest request) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		AbonnementRelationDAO aboDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
		ArrayList<AbonnementRelation> alAbo = (ArrayList<AbonnementRelation>) aboDAO.selectWhere("id_utilisateur="+idUser+" and id_source="+id);
		if (alAbo.size()>0) {
			//On était abonné, on se désabonne
			for (AbonnementRelation abonnementRelation : alAbo) {
				aboDAO.deleteById(abonnementRelation.id);
			}
			model.addAttribute("msgInfo", "Désabonnement effectué");
		}else {
			aboDAO.insert(new AbonnementRelation(0, idUser, id));
			model.addAttribute("msgInfo", "Abonnement effectué");
		}
		
		SourceDAO sourceDAO = ctx.getBean("sourceDAO", SourceDAO.class);
		Source source = (Source) sourceDAO.selectById(id);
		ThemeRelationDAO trDAO = ctx.getBean("themeRelationDAO",
				ThemeRelationDAO.class);
		return pageModif(model, source, trDAO, ctx);
	}
	
	//Masquer/Afficher
	@RequestMapping(value = "/user/source/masquer", method = RequestMethod.POST)
	public ModelAndView sourceMasquer(@RequestParam("id") int id,
			Model model, HttpServletRequest request) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		BlacklistageUtilisateurRelationDAO aboDAO = ctx.getBean("blacklistageUtilisateurRelationDAO", BlacklistageUtilisateurRelationDAO.class);
		ArrayList<BlacklistageUtilisateurRelation> alAbo = (ArrayList<BlacklistageUtilisateurRelation>) aboDAO.selectWhere("id_utilisateur="+idUser+" and id_source="+id);
		if (alAbo.size()>0) {
			//On était blacklisté, on se déblocklister
			for (BlacklistageUtilisateurRelation abonnementRelation : alAbo) {
				aboDAO.deleteById(abonnementRelation.id);
			}
			model.addAttribute("msgInfo", "Démasquage effectué");
		}else {
			aboDAO.insert(new BlacklistageUtilisateurRelation(0, idUser,id));
			model.addAttribute("msgInfo", "Masquage effectué");
		}
		
		SourceDAO sourceDAO = ctx.getBean("sourceDAO", SourceDAO.class);
		Source source = (Source) sourceDAO.selectById(id);
		ThemeRelationDAO trDAO = ctx.getBean("themeRelationDAO",
				ThemeRelationDAO.class);
		return pageModif(model, source, trDAO, ctx);
}

	
	// Utilisable pour les fonction qui va dans la page modif
	ModelAndView pageModif(Model model, Source source, ThemeRelationDAO trDAO,
			ClassPathXmlApplicationContext ctx) throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		// Collecter tous les thèmes associés
		ArrayList<Theme> alTheme = new ArrayList<Theme>();
		ThemeDAO themeDAO = ctx.getBean("themeDAO", ThemeDAO.class);
		ArrayList<ThemeRelation> alTR = (ArrayList<ThemeRelation>) trDAO
				.selectWhere("id_source=" + source.id);
		for (ThemeRelation themeRelation : alTR) {
			Theme theme = (Theme) themeDAO.selectById(themeRelation.id_theme);
			if (theme != null) {
				//Attention, ici on a modifier l'id du theme à l'id
				//du themeRelation correpondant!!
				theme.id = themeRelation.id;
				alTheme.add(theme);
			}
		}
		// La liste des thèmes restants
		ArrayList<Theme> alIdThemeRest = (ArrayList<Theme>) themeDAO
				.selectAll();
		for (Theme theme : alTheme) {
			for (Theme themeReste : alIdThemeRest) {
				if (theme.id == themeReste.id) {
					alIdThemeRest.remove(themeReste);
					break;
				}
			}
		}
		// Mettre les attributs dans la page générée
		model.addAttribute("id", source.getId());
		model.addAttribute("url_fournisseur", source.getUrl_fournisseur());
		model.addAttribute("titre", source.getTitre());
		model.addAttribute("niveau", source.getNiveau());
		model.addAttribute("zone", source.getZone());
		model.addAttribute("projection", source.getProjection());
		model.addAttribute("periodicite", source.getPeriodicite());
		model.addAttribute("description", source.getDescription());
		//check box "masqué"
		BlacklistageUtilisateurRelationDAO blcDAO = ctx.getBean("blacklistageUtilisateurRelationDAO", BlacklistageUtilisateurRelationDAO.class);
		ArrayList<BlacklistageUtilisateurRelation> alBlc = (ArrayList<BlacklistageUtilisateurRelation>) blcDAO.selectWhere("id_source="+source.id+" and id_utilisateur="+idUser);
		if (alBlc.size()>0) {
			model.addAttribute("masquer", "checked");
		}else {
			model.addAttribute("masquer", "");
		}
		//check box "abonnée"
		AbonnementRelationDAO aboDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
		ArrayList<AbonnementRelationDAO> alAbo = (ArrayList<AbonnementRelationDAO>) aboDAO.selectWhere("id_source="+source.id+" and id_utilisateur="+idUser);
		if (alAbo.size()>0) {
			model.addAttribute("abonner", "checked");
		}else {
			model.addAttribute("abonner", "");
		}
		// Mettre les deux ArrayList dans un map
		Map<String, Object> modelsMap = new HashMap<String, Object>();
		modelsMap.put("themes", alTheme);
		modelsMap.put("idThemes", alIdThemeRest);
		return new ModelAndView("user/source/modif", modelsMap);
	}
	
	
	// Utilisable pour afficher la liste ds sources
	ModelAndView pageConsulter(ClassPathXmlApplicationContext ctx, Model model) throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException {
		SourceDAO sourceDAO = ctx.getBean("sourceDAO", SourceDAO.class);
		// Récupérer la liste des sources et le transmettre à la page
		
		/** La liste de sources aboonées(avec masquage système) **/
		AbonnementRelationDAO abonneDAO= ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
		ArrayList<Source> alSourceAbonne = abonneDAO.listSourceByIdUtilisateurAvecMasquage(idUser);
		/** La liste de sources dispo(non bloque par systeème, ni par user) **/
		BlacklistageUtilisateurRelationDAO blcDAO= ctx.getBean("blacklistageUtilisateurRelationDAO", BlacklistageUtilisateurRelationDAO.class);
		ArrayList<Source> alSourceDispo = blcDAO.listeSourceDispoByIdUser(idUser);
		/** La liste de sources masquées(par user) **/
		ArrayList<Source> alSourceMasquee = blcDAO.listeSourceMasqueeByIdUser(idUser);
		
		
		// Mettre les trois ArrayList dans un map
		Map<String, Object> modelsMap = new HashMap<String, Object>();
		modelsMap.put("sourcesAbonne", alSourceAbonne);
		modelsMap.put("sourcesMasquee", alSourceMasquee);
		modelsMap.put("sourcesDispo", alSourceDispo);
		return new ModelAndView("user/source/consulter", modelsMap);
	}
	
	//Consulter la liste des sources
	@RequestMapping(value = "/user/source/consulter", method = RequestMethod.GET)
	public ModelAndView sourceConsulter(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		BlacklistageSystemeDAO blcDAO = ctx.getBean("blacklistageSystemeDAO", BlacklistageSystemeDAO.class);
		ArrayList<Integer> alIdSourceM = blcDAO.idSourceList();
		return pageConsulter(ctx,model);
	}

	

}
