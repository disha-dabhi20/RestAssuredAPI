/**
 * 
 */
package com.employeeapi.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.BaseClass.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author Rahul Dabhi
 *
 */
public class Delete_Employee_Record extends BaseClass
{
	RequestSpecification httpRequest;
	Response response;
		
	@BeforeClass
	public void deleteEmployee() throws InterruptedException
	{
		logger.info(" Delete Employee Record ");
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		httpRequest = RestAssured.given();
		
		response = httpRequest.request(Method.GET, "/employees");
				
		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
			 
		//Capture id
		String empID=jsonPathEvaluator.get("[0].id");
		response = httpRequest.request(Method.DELETE, "/delete/" + empID); //Pass the ID to delete record
		
		Thread.sleep(3000);
	}

}