 package com.employeeapi.BaseClass;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass 
{
	public static RequestSpecification httpRequest;
	public static Response response;
	public String empID = "10"; //Hard coded - Input for Get details of Single Employee & update employee
	
	
	public Logger logger;
	
	@BeforeClass
	public void setup()
	{		
		logger=Logger.getLogger("EmployeesRestAPI");//adding Logger
		PropertyConfigurator.configure("Log4j.properties"); //adding logger to this file
		logger.setLevel(Level.DEBUG);		
	}
}
