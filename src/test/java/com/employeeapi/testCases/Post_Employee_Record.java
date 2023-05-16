/**
 * 
 */
package com.employeeapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.BaseClass.BaseClass;
import com.employeeapi.Utilities.Utility;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Disha Dabhi
 *
 */
public class Post_Employee_Record extends BaseClass
{
	RequestSpecification httpRequest;
	Response response;
	
	String empName = Utility.empName();
	String empSalary = Utility.empSal();
	String empAge = Utility.empAge();
	
	@BeforeClass
	void createEmployee() throws InterruptedException
	{
		logger.info(" Post Employee Record ");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("name", empName); 
		requestParams.put("salary", empSalary);
		requestParams.put("age", empAge);
		
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");

		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());

		response = httpRequest.request(Method.POST, "/create");
		
		Thread.sleep(5000);
	}
	
	@Test
	public void checkResposeBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(empName), true);
		Assert.assertEquals(responseBody.contains(empSalary), true);
		Assert.assertEquals(responseBody.contains(empAge), true);
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
		String statusLine = response.getStatusLine(); // Getting the status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	public void checkContentType()
	{
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "text/html; charset=iso-8859-1");
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info(" Finished Post Employee Record ");
	}
}
