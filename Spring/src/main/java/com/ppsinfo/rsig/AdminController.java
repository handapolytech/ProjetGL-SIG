package com.ppsinfo.rsig;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminHome(@Validated Admin admin, Model model) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, SQLException {
		
		switch (admin.getChoixFonction()) {
//		case Admin.ChoixSourceConsulter:
//			return "admin/source/consulter";
//		case Admin.ChoixSourceAjout:
//			return "admin/source/ajout";
//		case Admin.ChoixSourceModif:
//			return "admin/source/modif";
//		case Admin.ChoixSourceSuppr:
//			return "admin/source/suppr";
//		case Admin.ChoixSourceAjoutVersion:
//			return "admin/version/ajout";
//		case Admin.ChoixSourceSupprVersion:
//			return "admin/version/suppr";
//		case Admin.ChoixThemeConsulter:
//			return "admin/theme/consulter";
//		case Admin.ChoixThemeAjout:
//			return "admin/theme/ajout";
//		case Admin.ChoixBlacklisteSysConsulter:
//			return "admin/blacklisteSys/consulter";
//		case Admin.ChoixBlacklisteSysAjout:
//			return "admin/blacklisteSys/ajout";
//		case Admin.ChoixBlacklisteSysSuppr:
//			return "admin/blacklisteSys/suppr";
//		case Admin.ChoixAlerteUtilisateurAjout:
//			return "admin/alretUtilisateur/ajout";
//		case Admin.ChoixListeDemandeModifConsulter:
//			return "admin/demandModif/consulter";
		default:
			return "admin/admin";
		}
		
		
		
		
	}
	 
	
}
