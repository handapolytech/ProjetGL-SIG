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
public class AdminThemeController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminThemeController.class);
	
	
	/**Bloc Theme **/
	
	//Par défaut, accéder à la page de consultation des themes
	@RequestMapping(value = "/admin/theme/", method = RequestMethod.GET)
    public ModelAndView themeDefaut(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ThemeDAO themeDAO = ctx.getBean("themeDAO", ThemeDAO.class);
		//Récupérer la liste des themes et le transmettre à la page
		ArrayList<Theme> alTheme = (ArrayList<Theme>) themeDAO.selectAll();
        return new ModelAndView("admin/theme/consulter","themes",alTheme);	
    }
	
	@RequestMapping(value = "/admin/theme/ajout", method = RequestMethod.GET)
    public String sourceAjout(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		return "admin/theme/ajout";	
	}
	
	/*
	 * Traiter l'ajout et la modification d'une theme
	 */
	@RequestMapping(value = "/admin/theme/modif", method = RequestMethod.POST)
    public String themeAjoutModif(@Validated com.ppsinfo.rsig.jdbc.model.Theme theme, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ThemeDAO themeDAO = ctx.getBean("themeDAO", ThemeDAO.class);
        //Insérer theme dans son tableau et récupérer son id dans idTheme
		//si id = 0, le theme est nouvelle et on l'insère dans la BD
		//sinon, c'est une theme existante et on l'affiche
		if (theme.getId() == 0) {
			//insert
			theme.setId(themeDAO.insert(theme));
			model.addAttribute("msgInfo", "<p>Ajout éffectuée</p>");
		}else {
			//update
			themeDAO.update(theme);
			model.addAttribute("msgInfo", "<p>Modification éffectuée</p>");
		}
        //Mettre les attributs dans la page générée
		model.addAttribute("id", theme.getId());
        model.addAttribute("theme", theme.getTheme());
        return "admin/theme/modif";
    }
	
	@RequestMapping(value = "/admin/theme/modif", method = RequestMethod.GET)
    public String themeDetail(@RequestParam("id")int id,Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ThemeDAO themeDAO = ctx.getBean("themeDAO", ThemeDAO.class);
        Theme theme = (Theme) themeDAO.selectById(id);
		if (theme == null) {
			model.addAttribute("msgInfo", "Erreur selection: Aucune theme a pour id "+theme.getId());
			return "admin/theme/consulter"; 
		}else {
			//Mettre les attributs dans la page générée
			model.addAttribute("id", theme.getId());
	        model.addAttribute("theme", theme.getTheme());
	        return "admin/theme/modif";
		}
    }
	
	@RequestMapping(value = "/admin/theme/consulter", method = RequestMethod.GET)
    public ModelAndView themeConsulter(HttpServletRequest request,HttpServletResponse response, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ThemeDAO themeDAO = ctx.getBean("themeDAO", ThemeDAO.class);
		//Récupérer la liste des themes et le transmettre à la page
		ArrayList<Theme> alTheme = (ArrayList<Theme>) themeDAO.selectAll();
        return new ModelAndView("admin/theme/consulter","themes",alTheme);
    }
	
	@RequestMapping(value = "/admin/theme/suppr", method = RequestMethod.GET)
    public ModelAndView sourcSuppr(@RequestParam("id")int id,Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, SQLException, InstantiationException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ThemeDAO themeDAO = ctx.getBean("themeDAO", ThemeDAO.class);
        Theme theme = (Theme) themeDAO.selectById(id);
		if (theme == null) {
			model.addAttribute("msgInfo", "Erreur suppression: Aucune theme a pour id "+id);
		}else {
			if (themeDAO.deleteById(id)>0) {
				model.addAttribute("msgInfo", "Suppression réussie: Le theme a été supprimée"+id);
			}else {
				model.addAttribute("msgInfo", "Erreur suppression: Aucune theme a pour id "+id);
			}
		}
		ArrayList<Theme> alTheme = (ArrayList<Theme>) themeDAO.selectAll();
        return new ModelAndView("admin/theme/consulter","themes",alTheme); 
    }
	
	 
	
}
