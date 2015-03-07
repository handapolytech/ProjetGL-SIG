package com.ppsinfo.rsig;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ppsinfo.rsig.jdbc.dao.TestDAO;
import com.ppsinfo.rsig.jdbc.model.Test;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws SQLException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException, SQLException {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Locale locale, Model model) {
        return "login";
    }
	
	//Destination: home
	@RequestMapping(value = "/home", method = RequestMethod.POST)
    public String login(@Validated User user, Model model) {
        model.addAttribute("userName", user.getUserName());
        return "user";
    }
	
	@RequestMapping(value = "/jdbcTestsEntry", method = RequestMethod.GET)
    public String jdbsTestsEntry(Locale locale, Model model) {
        return "jdbcTestsEntry";
    }
	
	@RequestMapping(value = "/jdbcTests", method = RequestMethod.POST)
    public String jdbsTests(@Validated JDBCTests jdbc, Model model) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, SQLException {
        model.addAttribute("tableName", jdbc.getTableName());
        //générer les autres attribut
        jdbc.generateAttributes();
        model.addAttribute("insert", jdbc.getInsert());
        model.addAttribute("selectById", jdbc.getSelectById() );
        model.addAttribute("update", jdbc.getUpdate());
        model.addAttribute("resultatUpdate", jdbc.getResultatUpdate() );
        model.addAttribute("selectAll", jdbc.getSelectAll() );
		model.addAttribute("ligne1", jdbc.getLigne1());
        model.addAttribute("condition", jdbc.getCondition());
        model.addAttribute("selectWhere", jdbc.getSelectWhere());
		model.addAttribute("ligne11", jdbc.getLigne11());
        model.addAttribute("deleteById", jdbc.getDeleteById());
        model.addAttribute("debugLine", jdbc.getDebugLine());
        return "jdbcTests";
    }
	 
	
}
