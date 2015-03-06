package com.ppsinfo.rsig.jdbc.model;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ppsinfo.rsig.jdbc.dao.TestDAO;

public class SpringMain {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		//Get the Spring Context
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
         
        //Get the EmployeeDAO Bean
        TestDAO employeeDAO = ctx.getBean("testDAO", TestDAO.class);
         
        //Run some tests for JDBC CRUD operations
        Test emp = new Test();
        int rand = 4;
        Test emp1 = employeeDAO.selectById(rand);
        System.out.println("Employee Retrieved::"+emp1);

	}

}
