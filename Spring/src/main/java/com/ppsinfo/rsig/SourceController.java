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
public class SourceController {

	private static final Logger logger = LoggerFactory
			.getLogger(SourceController.class);

	/** Bloc Source **/

	// Par défaut, accéder à la page de consultation des sources
	@RequestMapping(value = "/admin/source/", method = RequestMethod.GET)
	public ModelAndView sourceDefaut(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		SourceDAO sourceDAO = ctx.getBean("sourceDAO", SourceDAO.class);
		// Récupérer la liste des sources et le transmettre à la page
		ArrayList<Source> alSource = (ArrayList<Source>) sourceDAO.selectAll();
		return new ModelAndView("admin/source/consulter", "sources", alSource);
	}

	//Page pour ajouter une source (formulaire)
	@RequestMapping(value = "/admin/source/ajout", method = RequestMethod.GET)
	public ModelAndView sourceAjout(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		ThemeDAO themeDAO = ctx.getBean("themeDAO", ThemeDAO.class);
		ArrayList<Theme> alTheme = (ArrayList<Theme>) themeDAO.selectAll();
		return new ModelAndView("admin/source/ajout", "themeList", alTheme);
	}

	/*
	 * Traiter l'ajout et la modification d'une source
	 */
	@RequestMapping(value = "/admin/source/modif", method = RequestMethod.POST)
	public ModelAndView sourceAjoutModif(
			@Validated com.ppsinfo.rsig.jdbc.model.Source source, Model model)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException {
		//false si l'opération s'agit d'une modification (update)
		boolean ajout = true;
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		SourceDAO sourceDAO = ctx.getBean("sourceDAO", SourceDAO.class);
		// Insérer source dans son tableau et récupérer son id dans idSource
		// si id = 0, la source est nouvelle et on l'insère dans la BD
		// sinon, c'est une source existante et on l'affiche
		if (source.getId() == 0) {
			// insert
			source.setId(sourceDAO.insert(source));
			model.addAttribute("msgInfo", "<p>Ajout éffectuée</p>");
		} else {
			ajout = false;
			// update
			sourceDAO.update(source);
			model.addAttribute("msgInfo", "<p>Modification éffectuée</p>");
		}
		//Ajouter les alerte
		ArrayList<AlerteRelation> alAlerte = new ArrayList<AlerteRelation>();
		if (ajout) {
			UtilisateurDAO userDAO = ctx.getBean("utilisateurDAO", UtilisateurDAO.class);
			ArrayList<Utilisateur> alUser = (ArrayList<Utilisateur>) userDAO.selectAll();
			for (Utilisateur utilisateur : alUser) {
				alAlerte.add(new AlerteRelation(0, utilisateur.id, source.id, AlerteRelation.defautValuePeriodicite, new Date(), "Nouvelle Source Ajoutée: "+source.titre, "ajout", "réussi", source.description));
			}
		}else {
			AbonnementRelationDAO abonneDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
			ArrayList<AbonnementRelation> alAbonne = (ArrayList<AbonnementRelation>) abonneDAO.selectWhere("id_source="+source.id);
			for (AbonnementRelation abonnementRelation : alAbonne) {
				alAlerte.add(new AlerteRelation(0, abonnementRelation.id_utilisateur, source.id, AlerteRelation.defautValuePeriodicite, new Date(), "Source Modifiée: "+source.titre, "modif", "réussi", source.description));
			}
		}
		AlerteRelationDAO alerteDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
		for (AlerteRelation alerte : alAlerte) {
			alerteDAO.insert(alerte);
		}
		// Collecter tous les thèmes associés
		ThemeRelationDAO trDAO = ctx.getBean("themeRelationDAO",
				ThemeRelationDAO.class);
		return pageModif(model, source, trDAO, ctx);
	}

	// Afficher le détail
	@RequestMapping(value = "/admin/source/modif", method = RequestMethod.GET)
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
			return new ModelAndView("admin/source/consulter", "sources",
					alSource);
		} else {
			ThemeRelationDAO trDAO = ctx.getBean("themeRelationDAO",
					ThemeRelationDAO.class);

			return pageModif(model, source, trDAO, ctx);
		}
	}

	// Associer un theme
	@RequestMapping(value = "/admin/source/modif_associer_theme", method = RequestMethod.GET)
	public ModelAndView sourceRTAssocier(@RequestParam("id") int id,
			@RequestParam("id_theme_associer") int id_theme_associer,
			Model model) throws NoSuchFieldException, SecurityException,
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
			return new ModelAndView("admin/source/consulter", "sources",
					alSource);
		} else {
			ThemeRelationDAO trDAO = ctx.getBean("themeRelationDAO",
					ThemeRelationDAO.class);
			if (id_theme_associer > 0) {
				ThemeRelation tr = new ThemeRelation(0, id, id_theme_associer);
				if (trDAO.insert(tr) > 0) {
					model.addAttribute("msgInfo", "Le thème de l'id "
							+ id_theme_associer
							+ " est associé à la source actuelle");
				} else {
					model.addAttribute("msgInfo",
							"Erreur: la source actuelle n'est pas associé avec le thème de l'id "
									+ id_theme_associer);
				}
			}
			//Ajouter les alerte
			ArrayList<AlerteRelation> alAlerte = new ArrayList<AlerteRelation>();
			AbonnementRelationDAO abonneDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
			ArrayList<AbonnementRelation> alAbonne = (ArrayList<AbonnementRelation>) abonneDAO.selectWhere("id_source="+source.id);
			for (AbonnementRelation abonnementRelation : alAbonne) {
				alAlerte.add(new AlerteRelation(0, abonnementRelation.id_utilisateur, source.id, AlerteRelation.defautValuePeriodicite, new Date(), "Source Modifiée: "+source.titre, "modif", "réussi", source.description));
			}
			AlerteRelationDAO alerteDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
			for (AlerteRelation alerte : alAlerte) {
				alerteDAO.insert(alerte);
			}
			return pageModif(model, source, trDAO, ctx);
		}
	}

	// Rétirer un theme
	@RequestMapping(value = "/admin/source/modif_retirer_theme", method = RequestMethod.GET)
	public ModelAndView sourceRTRetirer(@RequestParam("id") int id,
			@RequestParam("id_tr_retirer") int id_tr_retirer, Model model)
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
			return new ModelAndView("admin/source/consulter", "sources",
					alSource);
		} else {
			ThemeRelationDAO trDAO = ctx.getBean("themeRelationDAO",
					ThemeRelationDAO.class);
			if (id_tr_retirer > 0) {
				if (trDAO.deleteById(id_tr_retirer) > 0) {
					model.addAttribute("msgInfo", "Un thème est retiré de la source actuelle");
				} else {
					model.addAttribute("msgInfo",
							"Erreur: Aucune relation entre la source actuelle et un thème a pour l'id "
									+ id_tr_retirer);
				}

			}
			//Ajouter les alerte
			ArrayList<AlerteRelation> alAlerte = new ArrayList<AlerteRelation>();
			AbonnementRelationDAO abonneDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
			ArrayList<AbonnementRelation> alAbonne = (ArrayList<AbonnementRelation>) abonneDAO.selectWhere("id_source="+source.id);
			for (AbonnementRelation abonnementRelation : alAbonne) {
				alAlerte.add(new AlerteRelation(0, abonnementRelation.id_utilisateur, source.id, AlerteRelation.defautValuePeriodicite, new Date(), "Source Modifiée: "+source.titre, "modif", "réussi", source.description));
			}
			AlerteRelationDAO alerteDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
			for (AlerteRelation alerte : alAlerte) {
				alerteDAO.insert(alerte);
			}
			return pageModif(model, source, trDAO, ctx);
		}
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
		// Mettre les deux ArrayList dans un map
		Map<String, Object> modelsMap = new HashMap<String, Object>();
		modelsMap.put("themes", alTheme);
		modelsMap.put("idThemes", alIdThemeRest);
		return new ModelAndView("admin/source/modif", modelsMap);
	}
	
	//
	@RequestMapping(value = "/admin/source/consulter", method = RequestMethod.GET)
	public ModelAndView sourceConsulter(HttpServletRequest request,
			HttpServletResponse response, Model model)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		SourceDAO sourceDAO = ctx.getBean("sourceDAO", SourceDAO.class);
		// Récupérer la liste des sources et le transmettre à la page
		ArrayList<Source> alSource = (ArrayList<Source>) sourceDAO.selectAll();
		return new ModelAndView("admin/source/consulter", "sources", alSource);
	}

	//Supprimer une source
	@RequestMapping(value = "/admin/source/suppr", method = RequestMethod.GET)
	public ModelAndView sourceSuppr(@RequestParam("id") int id, Model model)
			throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, SQLException,
			InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		
		//Suppression de la source
		SourceDAO sourceDAO = ctx.getBean("sourceDAO", SourceDAO.class);
		Source source = (Source) sourceDAO.selectById(id);
		if (source == null) {
			model.addAttribute("msgInfo",
					"Erreur suppression: Aucune source a pour id " + id);
		} else {
			//Prévenir les abonnés d'abord, puisque qu'une fois supprimé,
			//les relations des abonnées et les alertes associés seront être retiréauto par trigger
			ArrayList<AlerteRelation> alAlerte = new ArrayList<AlerteRelation>();
			AbonnementRelationDAO abonneDAO = ctx.getBean("abonnementRelationDAO", AbonnementRelationDAO.class);
			ArrayList<AbonnementRelation> alAbonne = (ArrayList<AbonnementRelation>) abonneDAO.selectWhere("id_source="+source.id);
			for (AbonnementRelation abonnementRelation : alAbonne) {
				alAlerte.add(new AlerteRelation(0, abonnementRelation.id_utilisateur, 1, AlerteRelation.defautValuePeriodicite, new Date(), "Source(id:"+source.id+") Supprimé: "+source.titre, "suppr", "réussi", source.description));
			}
			AlerteRelationDAO alerteDAO = ctx.getBean("alerteRelationDAO", AlerteRelationDAO.class);
			for (AlerteRelation alerte : alAlerte) {
				alerteDAO.insert(alerte);
			}
			if (sourceDAO.deleteById(id) > 0) {
				model.addAttribute("msgInfo",
						"Suppression réussie: La source a été supprimée" + alAbonne.size());
			} else {
				model.addAttribute("msgInfo",
						"Erreur suppression: Aucune source a pour id " + id);
			}
		}
		ArrayList<Source> alSource = (ArrayList<Source>) sourceDAO.selectAll();
		return new ModelAndView("admin/source/consulter", "sources", alSource);
	}

}
