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
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Disha Dabhi
 *
 */
public class Get_Single_Employee_Record extends BaseClass
{
	RequestSpecification httpRequest;
	Response response;
		
	@BeforeClass
	public void getEmployeeData() throws InterruptedException
	{
		logger.info(" Get Single Employee Record ");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, "/employee/" + empID);
		
		Thread.sleep(7000);
	}
	
	@Test
	public void checkResposeBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empID), false);
	}
		
	@Test
	public void checkStatusCode()
	{
		int statusCode = response.getStatusCode(); // Getting the status code
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void checkstatusLine()
	{
		String statusLine = response.getStatusLine(); // Gettng status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	public void checkContentType()
	{
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info(" Get Single Employee Record ");
	}
}