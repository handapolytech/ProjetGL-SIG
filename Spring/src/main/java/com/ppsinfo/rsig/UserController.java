package com.ppsinfo.rsig;

import java.sql.SQLException;
import java.util.ArrayList;

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

import com.ppsinfo.rsig.jdbc.dao.BlacklistageSystemeDAO;
import com.ppsinfo.rsig.jdbc.dao.BlacklistageUtilisateurRelationDAO;
import com.ppsinfo.rsig.jdbc.dao.SourceDAO;
import com.ppsinfo.rsig.jdbc.model.Source;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	//TODO Remplacer ca par la variable dans la session!!!
			int idUser = 1;
			
			
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userHome(@Validated Admin user, Model model)
			throws InstantiationException, IllegalAccessException,
			NoSuchFieldException, SecurityException, IllegalArgumentException,
			SQLException {

		switch (user.getChoixFonction()) {
		// case Admin.ChoixSourceConsulter:
		// return "user/source/consulter";
		// case Admin.ChoixSourceAjout:
		// return "user/source/ajout";
		// case Admin.ChoixSourceModif:
		// return "user/source/modif";
		// case Admin.ChoixSourceSuppr:
		// return "user/source/suppr";
		// case Admin.ChoixSourceAjoutVersion:
		// return "user/version/ajout";
		// case Admin.ChoixSourceSupprVersion:
		// return "user/version/suppr";
		// case Admin.ChoixThemeConsulter:
		// return "user/theme/consulter";
		// case Admin.ChoixThemeAjout:
		// return "user/theme/ajout";
		// case Admin.ChoixBlacklisteSysConsulter:
		// return "user/blacklisteSys/consulter";
		// case Admin.ChoixBlacklisteSysAjout:
		// return "user/blacklisteSys/ajout";
		// case Admin.ChoixBlacklisteSysSuppr:
		// return "user/blacklisteSys/suppr";
		// case Admin.ChoixAlerteUtilisateurAjout:
		// return "user/alretUtilisateur/ajout";
		// case Admin.ChoixListeDemandeModifConsulter:
		// return "user/demandModif/consulter";
		default:
			return "user/user";
		}

	}

	@RequestMapping(value = "/user/recherche", method = RequestMethod.GET)
	public ModelAndView rechercheSource(@Validated Admin user, Model model,
			@RequestParam("mot") String mot) throws InstantiationException,
			IllegalAccessException, NoSuchFieldException, SecurityException,
			IllegalArgumentException, SQLException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		SourceDAO sourceDAO = ctx.getBean("sourceDAO", SourceDAO.class);
		ArrayList<Source> alSource = (ArrayList<Source>) sourceDAO
				.selectWhere(Source.fieldTitre + " LIKE '%" + mot + "%' or "
						+ Source.fieldNiveau + " LIKE '%" + mot + "%' or "
						+ Source.fieldProjection + " LIKE '%" + mot + "%' or "
						+ Source.fieldZone + " LIKE '%" + mot + "%'");
		model.addAttribute("mot",mot);
		//Retirer les sources masqués
		ArrayList<Source> result = new ArrayList<Source>();
		BlacklistageSystemeDAO blcSysDAO = ctx.getBean("blacklistageSystemeDAO",BlacklistageSystemeDAO.class);
		ArrayList<Integer> alSourceMSys =blcSysDAO.idSourceList();
		BlacklistageUtilisateurRelationDAO blcUsrDAO  = ctx.getBean("blacklistageUtilisateurRelationDAO",BlacklistageUtilisateurRelationDAO.class);
		ArrayList<Integer> alSourceMUsr =blcUsrDAO.listeIdSourceMasqueeByIdUser(idUser);
		for (Source source : alSource) {
			if (alSourceMSys.contains(source.id) || alSourceMUsr.contains(source.id)) {
				
			}else {
				result.add(source);
			}
		}
		return new ModelAndView("user/recherche", "sources", result);
	}

}
