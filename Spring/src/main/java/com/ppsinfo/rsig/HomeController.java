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
		
		
		//Tester le JDBC
		//Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        //Get the EmployeeDAO Bean
        TestDAO testDAO = ctx.getBean("testDAO", TestDAO.class);
        //Run some tests for JDBC CRUD operations
        
        
        //insert
        Test newT = new Test(0, 99, "Hello", "sample", new Date());
        int newId = testDAO.insert(newT);
        model.addAttribute("insert", newId);
        //selecById
        Test t = testDAO.selectById(newId);
        model.addAttribute("selectById", t!=null?t:"rien" );
        //update
        t.num = 32559;
        model.addAttribute("update", testDAO.update(t));
        t = testDAO.selectById(newId);
        model.addAttribute("resultatUpdate", t!=null?t:"rien" );
        //selectAll
        ArrayList<Test> alTest = testDAO.selectAll();
        model.addAttribute("selectAll", alTest.size() );
        if (alTest.size()==0) {
        	model.addAttribute("ligne1", "rien" );
		}else {
			model.addAttribute("ligne1", alTest.get(0) );
		}
        //selectWhere
        String condition = "string = 'aaa'";
        model.addAttribute("condition", condition);
        ArrayList<Test> alTest1 = testDAO.selectWhere(condition);
        model.addAttribute("selectWhere", alTest1.size() );
        if (alTest1.size()==0) {
        	model.addAttribute("ligne11", "rien" );
		}else {
			model.addAttribute("ligne11", alTest1.get(0) );
		}
        //deleteById
        model.addAttribute("deleteById", testDAO.deleteById(newId));
        
        
		
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
	 
	
}
