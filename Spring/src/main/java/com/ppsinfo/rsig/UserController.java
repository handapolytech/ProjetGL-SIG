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
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String userHome(@Validated Admin user, Model model) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, SQLException {
		
		switch (user.getChoixFonction()) {
//		case Admin.ChoixSourceConsulter:
//			return "user/source/consulter";
//		case Admin.ChoixSourceAjout:
//			return "user/source/ajout";
//		case Admin.ChoixSourceModif:
//			return "user/source/modif";
//		case Admin.ChoixSourceSuppr:
//			return "user/source/suppr";
//		case Admin.ChoixSourceAjoutVersion:
//			return "user/version/ajout";
//		case Admin.ChoixSourceSupprVersion:
//			return "user/version/suppr";
//		case Admin.ChoixThemeConsulter:
//			return "user/theme/consulter";
//		case Admin.ChoixThemeAjout:
//			return "user/theme/ajout";
//		case Admin.ChoixBlacklisteSysConsulter:
//			return "user/blacklisteSys/consulter";
//		case Admin.ChoixBlacklisteSysAjout:
//			return "user/blacklisteSys/ajout";
//		case Admin.ChoixBlacklisteSysSuppr:
//			return "user/blacklisteSys/suppr";
//		case Admin.ChoixAlerteUtilisateurAjout:
//			return "user/alretUtilisateur/ajout";
//		case Admin.ChoixListeDemandeModifConsulter:
//			return "user/demandModif/consulter";
		default:
			return "user/user";
		}
		
		
		
		
	}
	 
	
}
