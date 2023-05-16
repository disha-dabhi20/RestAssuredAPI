/**
 * 
 */
package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.BaseClass.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;

/**
 * @author Disha Dabhi
 *
 */
public class Get_All_Employees extends BaseClass
{
	@BeforeClass
	public void getAllEmployees() throws InterruptedException
	{
		logger.info(" Started Get All Employees ");
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET,"/employees");
		
		Thread.sleep(5);
	}
	
	@Test
	public void checkResposeBody()
	{
		logger.info(" Checking Respose Body ");
		
		String responseBody = response.getBody().asString();
		logger.info("Response Body==>" + responseBody);
		Assert.assertTrue(responseBody != null);
		
	}
		
	@Test
	public void checkStatusCode()
	{
		logger.info(" Checking Status Code ");
		
		int statusCode = response.getStatusCode(); //For Getting status code
		logger.info("Status Code is ==>" + statusCode); //200
		Assert.assertEquals(statusCode, 200);
		
	}
		
	@Test
	public void checkstatusLine()
	{
		logger.info(" Checking Status Line ");
		
		String statusLine = response.getStatusLine(); // Getting the status Line
		logger.info("Status Line is ==>" + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");		
	}
	
	
	@Test
	public void checkContentType()
	{
		logger.info(" Checking Content Type ");
		
		String contentType = response.header("Content-Type");
		logger.info("Content type is ==>" + contentType);
		Assert.assertEquals(contentType, "application/json");
	}

	
	@AfterClass
	public void tearDown()
	{
		logger.info(" Finish Get All Employees ");
	}
}
